package com.codingdojo.auth.controllers;

import java.security.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.auth.models.User;
import com.codingdojo.auth.services.UserService;
import com.codingdojo.auth.validators.UserValidator;



@Controller
public class Users {
	
	  private UserService userService;
	    private UserValidator userValidator;
	    
	    public Users(UserService userService, UserValidator userValidator) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    	 userValidator.validate(user, result);
         if (result.hasErrors()) {
             return "registrationPage.jsp";
         }
         
         
         List<User> allUsers = userService.allUser();
 		boolean adminExists = false;

 		for (int i = 0; i < allUsers.size(); i++) {
 			User u = allUsers.get(i);
 			if (u.getRoles().get(0).getName().equals("ROLE_ADMIN")) {
 				adminExists = true;
 			}
 		}

 		if (!adminExists) {
 			userService.saveUserWithAdminRole(user);
 			return "redirect:/";
 		} else {
 			userService.saveWithUserRole(user);
 			return "redirect:/";
 		}
        
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        List<User> everyone = userService.allUser();
		model.addAttribute("everyone", everyone);
        return "adminPage.jsp";
    }
    
    @RequestMapping("/admin/{id}/delete")
	public String deleteAccount(@PathVariable("id") Long id) {
		userService.deleteAccount(id);
		return "redirect:/admin";
	}

	@RequestMapping("/admin/{id}/makeAdmin")
	public String makeAdmin(@PathVariable("id") Long id) {
		User user = userService.findUserById(id);
		userService.userToAdmin(user);
		return "redirect:/admin";
	}
    
    
    
    
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("user", user);

        return "homePage.jsp";
    }
}