package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.ProductException;
import com.kishi.ecommerce_api.model.Rating;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating CreateRating(RatingRequest req, User user)throws ProductException;

    public List<Rating> getProductsRating(Long productId);
}
