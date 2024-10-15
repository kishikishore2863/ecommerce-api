//package com.kishi.ecommerce_api.repository;
//
//import com.kishi.ecommerce_api.model.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.parameters.P;
//
//import java.util.List;
//
//public interface ProductRepository extends JpaRepository<Product,Long> {
//
//
//
//    @Query("SELECT p FROM Product p"+
//    "WHERE (p.category.name=:category OR :category='')"+
//      "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice))"+
//      "AND(:minDiscount IS NULL OR p.discountPresent>= :minDiscount)"+
//      "ORDER BY"+
//      "CASE WHEN :sort='price_Low'THEN p.discountPrice END ASC" +
//      "CASE WHEN :sort='price_High'THEN p.discountPrice END DESC"
//    )
//    public List<Product> filterProducts(@Param("category")String category,
//                                        @Param("minPrice")Integer minPrice,
//                                        @Param("maxPrice")Integer maxPrice,
//                                        @Param("minDiscount")Integer minDiscount,
//                                        @Param("sort")String sort
//                                        );
//
//}

package com.kishi.ecommerce_api.repository;

import com.kishi.ecommerce_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query to filter products based on category, price range, discount, and sort order
    @Query("SELECT p FROM Product p " +
            "WHERE (p.category.name = :category OR :category = '') " +
            "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountPrice BETWEEN :minPrice AND :maxPrice)) " +
            "AND (:minDiscount IS NULL OR p.discountPresent >= :minDiscount) " +
            "ORDER BY " +
            "CASE WHEN :sort = 'price_Low' THEN p.discountPrice END ASC, " +
            "CASE WHEN :sort = 'price_High' THEN p.discountPrice END DESC, " +
            "p.id") // Sort by ID as fallback if no sorting is specified
    List<Product> filterProducts(@Param("category") String category,
                                 @Param("minPrice") Integer minPrice,
                                 @Param("maxPrice") Integer maxPrice,
                                 @Param("minDiscount") Integer minDiscount,
                                 @Param("sort") String sort);
}
