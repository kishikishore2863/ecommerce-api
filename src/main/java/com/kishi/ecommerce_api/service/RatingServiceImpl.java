package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.ProductException;
import com.kishi.ecommerce_api.model.Product;
import com.kishi.ecommerce_api.model.Rating;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.repository.RatingRepository;
import com.kishi.ecommerce_api.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class RatingServiceImpl implements RatingService{

    private RatingRepository ratingRepository;
    private ProductService productService;

    public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }

    @Override
    public Rating CreateRating(RatingRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Rating rating =new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {


        return null;
    }
}
