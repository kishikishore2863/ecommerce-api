package com.kishi.ecommerce_api.repository;

import com.kishi.ecommerce_api.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {

    @Query(" SELECT r From Rating r WHERE r.product.id=:productId")
    public List<Rating>getAllProductRating(@Param("productId") Long productId);

}
