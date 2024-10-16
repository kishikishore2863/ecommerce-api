package com.kishi.ecommerce_api.service;


import com.kishi.ecommerce_api.exception.ProductException;
import com.kishi.ecommerce_api.model.Product;
import com.kishi.ecommerce_api.model.Review;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.repository.ProductRepository;
import com.kishi.ecommerce_api.repository.ReviewRepository;
import com.kishi.ecommerce_api.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview( ReviewRequest req,User user) {
        Long id=req.getProductId();
//        Product product =productService.findProductById(id);
        Product product;
        try {
             product =productService.findProductById(id);
        } catch (ProductException e) {
            return null;
        }
        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return  reviewRepository.save(review);
    }




    @Override
    public List<Review> getAllReview(Long productId) {

        return reviewRepository.getAllProductReviews(productId);
    }
}
