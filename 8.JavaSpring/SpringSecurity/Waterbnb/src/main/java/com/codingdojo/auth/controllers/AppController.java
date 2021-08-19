package com.codingdojo.auth.controllers;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.auth.models.Pool;
import com.codingdojo.auth.models.Review;
import com.codingdojo.auth.models.Role;

import com.codingdojo.auth.models.User;
import com.codingdojo.auth.services.PoolService;
import com.codingdojo.auth.services.ReviewService;

import com.codingdojo.auth.services.UserService;
import com.codingdojo.auth.validator.UserValidator;

@Controller
public class AppController {
	private UserService userService;
    private UserValidator userValidator;
    
    private PoolService poolService;
    private ReviewService reviewService;
    public AppController(UserService userService, UserValidator userValidator,PoolService poolService,
    		ReviewService reviewService) {
        this.userService = userService;
        this.userValidator = userValidator;
       
        this.poolService = poolService;
        this.reviewService = reviewService;
    }
	
	//////////////////////  Registration && Login && Logout ///////////////////////////////////////////
	@RequestMapping(value={"/guest/signin","/registration"})
    public String loginReg(@RequestParam(value="error", required=false) String error, 
    		@RequestParam(value="logout", required=false) String logout,
    		@ModelAttribute("user") User user, 
    		Model model) {
        if(error != null) {
            model.addAttribute("errorLog", "Usuario o Password no corresponden");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout ok");
        }
        return "loginReg.jsp";
    }
    
    @RequestMapping(value="/registration",method=RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, 
    		Model model,@RequestParam("role") String role) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
        	model.addAttribute("errorReg", "Campos con errores");
    		return "loginReg.jsp";
        }
        User u=userService.findByEmail(user.getEmail());
		if(u!=null) {
			model.addAttribute("errorReg", "Email ya esta registrado");
    		return "loginReg.jsp";
		}
		//elegir rol para registrar el usuario
		if(role.equals("HOST")) {
			userService.saveUserWithHostRole(user);
		}else if(role.equals("GUEST")) {
			userService.saveUserWithGuestRole(user);
		}else {
			model.addAttribute("errorReg", "Elegir tipo de usuario");
    		return "loginReg.jsp";
		}
        return "redirect:/guest/signin";
    }
	//////////////////////  Index ////////////////////////////////////////////
    //*****************************************************
    //Si role =Role_host, se dirige al dashboard del host
    //Si role =Role_guest se dirige a search
    //si no va al login, es decir no esta logeado
    //*****************************************************

    @RequestMapping("/")
    public String home(Principal principal) {
    	if(principal==null) {
    		return "index.jsp";
    	}
    	String email = principal.getName();
    	User user=userService.findByEmail(email);
        Role role=user.getRoles().get(0);
        if(role.getName().equals("ROLE_HOST")) {
        	return "redirect:/host/dashboard";
        }else if(role.getName().equals("ROLE_GUEST")) {
        	return "redirect:/search";
        }
        return "index.jsp";
    }
    /////////////////////////////// Search ////////////////////////////////////////////////
    @RequestMapping("/search")
    public String search(@RequestParam(value="location",required=false) String location,
    		Model model,Principal principal) {
    	if(principal!=null) {
    		String email = principal.getName();
            model.addAttribute("user", userService.findByEmail(email));
    	}
    	if(location==null) {
            return "search.jsp";
    	}
		if(location.length()<3||location.length()>200) {
			model.addAttribute("errorSearch", "Location name to short");
			return "search.jsp";
		}
		List<Pool> pools=poolService.findByAddress(location);
		model.addAttribute("pools", pools);
		return "search.jsp";
    }
    ///////////////////////////// pool Details ////////////////////////////////////////////////////
    @RequestMapping("/pools/{poolId}")
    public String poolInfo(Model model,@PathVariable("poolId") Long poolId,Principal principal) {
    	if(principal!=null) {
    		String email = principal.getName();
            model.addAttribute("user", userService.findByEmail(email));
    	}
    	Pool pool=poolService.findPool(poolId);
    	if(pool==null) {
    		return "redirect:/search";
    	}
    	model.addAttribute("pool", pool);
    	return "infoPool.jsp";
    }
    ///////////////////////////////pool review (guest)///////////////////////////////////////////
    @RequestMapping("/pools/{poolId}/review")
    public String poolreview (Model model,@PathVariable("poolId") Long poolId,Principal principal,
    		@ModelAttribute("review") Review review) {
    	String email = principal.getName();
    	User user=userService.findByEmail(email);
    	if(user==null||!user.getRoles().get(0).getName().equals("ROLE_GUEST")) {
    		return "redirect:/";
    	}
        
    	Pool pool=poolService.findPool(poolId);
    	if(pool==null) {
    		return "redirect:/search";
    	}
    	model.addAttribute("user", user);
    	model.addAttribute("pool", pool);
    	return "reviewPool.jsp";
    }
    @RequestMapping(value="/pools/{poolId}/review",method=RequestMethod.POST)
    public String addPoolReview(@Valid @ModelAttribute("review") Review review, BindingResult result,
    		@PathVariable("poolId") Long poolId,RedirectAttributes redirectAttributes,Principal principal) {
    	Pool pool=poolService.findPool(poolId);
    	if(pool==null) {
    		return "redirect:/";
    	}
    	 if (result.hasErrors()) {
    		 redirectAttributes.addFlashAttribute("errorRev", "Campos invalidos");
    	     return "redirect:/pools/"+poolId+"/review";
    	 }
    	 if(review.getComment().length()<1||review.getComment().length()>1000) {
    		 redirectAttributes.addFlashAttribute("errorRev", "Comment Invalido");
    	     return "redirect:/pools/"+poolId+"/review";
    	 }
    	 if(review.getRating()==null) {
    		 redirectAttributes.addFlashAttribute("errorRev", "Rating Invalido");
    	     return "redirect:/pools/"+poolId+"/review";
    	 }
    	 String email = principal.getName();
    	 User user=userService.findByEmail(email);
    	 if(user==null||!user.getRoles().get(0).getName().equals("ROLE_GUEST")) {
     		return "redirect:/";
    	 }
    	 //actualizar ratingAvg
    	 Double newRatingAvg=0.0;
    	 Double ratingAvg =pool.getRatingAvg();
    	 Double numberReviews=(double) pool.getReviewList().size();
    	 newRatingAvg=(ratingAvg*numberReviews+review.getRating())/(numberReviews+1);
    	 pool.setRatingAvg(newRatingAvg);
    	 poolService.createOrUpdatePool(pool);
    	 
    	 review.setUser(user);
    	 review.setPool(pool);
    	 reviewService.createOrUpdateReview(review);
    	 return "redirect:/pools/"+poolId;
    }
    /////////////////// Dashboard (Host) ////////////////////////////////////////////////////////
	@RequestMapping("/host/dashboard")
    public String adminPage(Principal principal, Model model,@ModelAttribute("pool") Pool pool) {
		String email = principal.getName();
		
        model.addAttribute("user", userService.findByEmail(email));
        return "dashboard.jsp";
    }
	
	  //*************************************************
	   //Cuandp se crea un nuevo list, se va al post
	   //se carga el principal para sacar el user
	   //se carga el listing para setear el user en el
	   //se crea el listing con la info establecida
	   //************************************************
	@RequestMapping(value="/host/addPool",method=RequestMethod.POST)
	public String addPool(Principal principal,@Valid @ModelAttribute("pool") Pool pool, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errorPool", "Campos invalidos");
    		return "redirect:/host/dashboard";
		    }
		if(pool.getDescription().length()<2||pool.getDescription().length()>1000) {
    		redirectAttributes.addFlashAttribute("errorPool", "Description invalid");
    		return "redirect:/host/dashboard";
    	}
		if(pool.getCost()==null||pool.getCost()<0||pool.getCost()>1000000) {
			redirectAttributes.addFlashAttribute("errorPool", "Invalid Cost");
    		return "redirect:/host/dashboard";
		}
		
		String email = principal.getName();
    	User user=userService.findByEmail(email);
    	
    	
    	
    	pool.setUser(user);
    	pool.setRatingAvg(0.0);
    	
    	poolService.createOrUpdatePool(pool);
    	
    	return "redirect:/host/dashboard";
	}
	////////////////////////////////// Edit pool (HOST) ////////////////////////////////////////////////////////
	@RequestMapping("/host/pools/{poolId}")
	public String editPool(Principal principal,@PathVariable("poolId") Long poolId,@ModelAttribute("pool") Pool pool,
			Model model) {
		String email = principal.getName();
    	User user=userService.findByEmail(email);
    	Pool p=poolService.findPool(poolId);
    	if(p==null) {
    		return "redirect:/host/dashboard";
    	}
    	if(!user.getPoolList().contains(p)) {
    		return "redirect:/host/dashboard";
    	}
    	
		
    	model.addAttribute("user", user);
    	model.addAttribute("pool", p);
		return "editPool.jsp";
	}
	@RequestMapping(value="/host/pools/{poolId}",method=RequestMethod.POST)
	public String editPool(Principal principal,@PathVariable("poolId") Long poolId,@Valid @ModelAttribute("pool") Pool pool,
			BindingResult result,RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errorPool", "Campos invalidos");
    		return "redirect:/host/pools/"+poolId;
		    }
		if(pool.getDescription().length()<2||pool.getDescription().length()>1000) {
    		redirectAttributes.addFlashAttribute("errorPool", "Description invalid");
    		return "redirect:/host/pools/"+poolId;
    	}
		if(pool.getCost()==null||pool.getCost()<0||pool.getCost()>1000000) {
			redirectAttributes.addFlashAttribute("errorPool", "Invalid Cost");
			return "redirect:/host/pools/"+poolId;
		}
		
		String email = principal.getName();
    	User user=userService.findByEmail(email);
    	
    	
    	Pool p=poolService.findPool(poolId);
    	if(p==null) {
    		return "redirect:/host/dashboard";
    	}
    	if(!user.getPoolList().contains(p)) {
    		return "redirect:/host/dashboard";
    	}
    	p.setAddress(pool.getAddress());
    	p.setDescription(pool.getDescription());
    	p.setCost(pool.getCost());
    	
    	
    	poolService.createOrUpdatePool(p);
    	
    	return "redirect:/host/dashboard";
	}

}