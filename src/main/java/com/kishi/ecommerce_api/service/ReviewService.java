package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.model.Review;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview( ReviewRequest req,User user );

    public List<Review> getAllReview(Long productId);


}
