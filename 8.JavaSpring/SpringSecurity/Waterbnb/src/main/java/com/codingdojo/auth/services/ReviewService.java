package com.codingdojo.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.auth.models.Review;
import com.codingdojo.auth.repositories.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> allReview() {
        return reviewRepository.findAll();
    }
    public Review findReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()) {
            return optionalReview.get();
        } else {
            return null;
        }
    }
	public Review createOrUpdateReview(Review review) {
        return reviewRepository.save(review);
    }
	public void deleteReview(Long id) {
    	Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()) {
        	reviewRepository.deleteById(id);
        } else {
            return;
        }
    }
}