package com.codingdojo.Eventos.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.Eventos.models.Event;
import com.codingdojo.Eventos.models.Message;
import com.codingdojo.Eventos.models.User;
import com.codingdojo.Eventos.repo.EventRepo;
import com.codingdojo.Eventos.repo.MessageRepo;
import com.codingdojo.Eventos.repo.UserRepo;

@Service
public class EventsService {
	
	private final UserRepo userRepo;
	private final EventRepo eventRepo;
	private final MessageRepo messageRepo;
	
	public EventsService(UserRepo userRepo, EventRepo eventRepo, MessageRepo messageRepo) {
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
		this.messageRepo = messageRepo;
	}
	
	
	// Event
	// Add a new event
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	
	// Get all events
	public List<Event> allEvents() {
		return (List<Event>) eventRepo.findAll();
	}
	
	// Find event by Id
	public Event findEventById(Long id) {
		Optional<Event> e = eventRepo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		else {
			return null;
		}
	}
	
	// Update event
	public void updateEvent(Event event) {
		eventRepo.save(event);
	}
	
	// Delete event
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
	
	// Message
	// Add a new message
	public Message addMessage(Message message) {
		return messageRepo.save(message);
	}
	
	// Save a message
	public void newMessage(Message message) {
		messageRepo.save(message);
	}
	
	// Update message
	public void updateMessage(Message message) {
    	messageRepo.save(message);
    }
    
	
	
	// User
	// User registration
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    // User authentication
    public boolean authenticateUser(String email, String password) {
    	User user = userRepo.findByEmail(email);
    	if(user == null) {
    		return false;
    	}
    	else {
    		if(BCrypt.checkpw(password, user.getPassword())) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    
    // Find user by email
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    // Find user by Id
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    // Duplicate user
    public boolean duplicateUser(String email) {
    	User user = userRepo.findByEmail(email);
    	if(user == null) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    // Update user
    public void updateUser(User user) {
        userRepo.save(user);
    } 
}
