package com.codingdojo.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.auth.models.User;
import com.codingdojo.auth.repositories.RoleRepository;
import com.codingdojo.auth.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    // 1
    public void saveUserWithHostRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_HOST"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithGuestRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_GUEST"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    //******************************************************************************
    //******************************************************************************
    
    public List<User> allUser() {
        return userRepository.findAll();
    }
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
	public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }
	public void deleteUser(Long id) {
    	Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
        	userRepository.deleteById(id);
        } else {
            return;
        }
    }
	public Long countAllUsers() {
		return userRepository.countAllUsers();
	}
}