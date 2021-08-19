package com.codingdojo.plantilla.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.plantilla.models.User;
import com.codingdojo.plantilla.service.UserService;
import com.codingdojo.plantilla.validator.UserValidator;

@Controller
public class UsersController {
    private final UserService userService;
    private final UserValidator userValidator;
    
    public UsersController(UserService userService,UserValidator userValidator) {
        this.userService = userService;
        this.userValidator=userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);//Validar pass
    	if (result.hasErrors()) {
    		return "registrationPage.jsp";
	    } else {
	    	user=userService.registerUser(user);
	    	Long id=user.getId();
	    	session.setAttribute("IdUsuario", id);
	    	return "redirect:/home";
	    }

    //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
    //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
    
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean aunt=userService.authenticateUser(email,password);
    	if(aunt) {
    		User user=userService.findByEmail(email);
    		Long id=user.getId();
    		session.setAttribute("IdUsuario", id);
    		return "redirect:/home";
    	}
    	else {
    		String error="Error, despailate";
    		model.addAttribute("error",error);
    		return "loginPage.jsp";
    	}
    	
    //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
    //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
    	
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long id=(Long) session.getAttribute("IdUsuario");
    	User user=userService.findUserById(id);
    	model.addAttribute("user",user);
    	
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	 return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
        // invalidar la sesión
        // redireccionar a la página de inicio de sesión.
    	 return "redirect:/login";
    }
}