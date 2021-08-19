package com.codingdojo.auth.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.auth.models.User;



@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> cla$$) {
        return User.class.equals(cla$$);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;    
        if (!u.getPasswordConfirmation().equals(u.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }	
}
