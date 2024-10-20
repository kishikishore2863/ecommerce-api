package com.kishi.ecommerce_api.repository;


import com.kishi.ecommerce_api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("SELECT r From Review r WHERE r.product.id=:productId")

    public List<Review>getAllProductReviews(@Param("productId")Long productId);


}
