//package com.kishi.ecommerce_api.model;
//
//import jakarta.persistence.*;
//
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "price")
//
//    private int price;
//
//    @Column(name = "discounted_price")
//    private int discountPrice;
//
//    @Column(name = "discount_persent")
//    private int discountPresent;
//
//    @Column(name = "quantity")
//    private int quantity;
//
//    @Column(name="brand")
//    private String brand;
//
//    @Column(name = "color")
//    private String color;
//
//    @Embedded
//    @ElementCollection
//    @Column(name = "sizes")
//    private Set<Size> sizes =new HashSet<>();
//
//    @Column(name = "image_url")
//    private String imageUrl;
//
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Rating>ratings=new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Review>reviews =new ArrayList<>();
//
//    @Column(name="num_ratings")
//    private int numRatings;
//
//    @ManyToOne()
//    @JoinColumn(name="category_id")
//    private Category category;
//
//    private LocalDateTime createdAt;
//
//    public Product(){
//
//    }
//
//    public Product(Long id, String title, String description, int price, int discountPrice, int discountPresent, int quantity, String brand, String color, Set<Size> sizes, String imageUrl, List<Rating> ratings, List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.discountPrice = discountPrice;
//        this.discountPresent = discountPresent;
//        this.quantity = quantity;
//        this.brand = brand;
//        this.color = color;
//        this.sizes = sizes;
//        this.imageUrl = imageUrl;
//        this.ratings = ratings;
//        this.reviews = reviews;
//        this.numRatings = numRatings;
//        this.category = category;
//        this.createdAt = createdAt;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getDiscountPrice() {
//        return discountPrice;
//    }
//
//    public void setDiscountPrice(int discountPrice) {
//        this.discountPrice = discountPrice;
//    }
//
//    public int getDiscountPresent() {
//        return discountPresent;
//    }
//
//    public void setDiscountPresent(int discountPresent) {
//        this.discountPresent = discountPresent;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        brand = brand;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Set<Size> getSizes() {
//        return sizes;
//    }
//
//    public void setSizes(Set<Size> sizes) {
//        this.sizes = sizes;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public List<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(List<Rating> ratings) {
//        this.ratings = ratings;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public int getNumRatings() {
//        return numRatings;
//    }
//
//    public void setNumRatings(int numRatings) {
//        this.numRatings = numRatings;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//}
//













//
//package com.kishi.ecommerce_api.model;
//
//import jakarta.persistence.*;
//
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "product")
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "price")
//    private int price;
//
//    @Column(name = "discounted_price")
//    private int discountPrice;
//
//    @Column(name = "discount_persent")
//    private int discountPresent;
//
//    @Column(name = "quantity")
//    private int quantity;
//
//    @Column(name="brand")
//    private String brand;
//
//    @Column(name = "color")
//    private String color;
//
////    @Embedded
////    @ElementCollection
////    @Column(name = "sizes")
//    @ElementCollection
//    @CollectionTable(
//            name = "product_sizes",
//            joinColumns = @JoinColumn(name = "product_id")
//    )
//    private Set<Size> sizes =new HashSet<>();
//
//    @Column(name = "image_url")
//    private String imageUrl;
//
////    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Rating>ratings=new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Review>reviews =new ArrayList<>();
//
//    @Column(name="num_ratings")
//    private int numRatings;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="category_id")
//    private Category category;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    public Product(){
//
//    }
//
//    public Product(Long id, String title, String description, int price, int discountPrice, int discountPresent, int quantity, String brand, String color, Set<Size> sizes, String imageUrl, List<Rating> ratings, List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.discountPrice = discountPrice;
//        this.discountPresent = discountPresent;
//        this.quantity = quantity;
//        this.brand = brand;
//        this.color = color;
//        this.sizes = sizes;
//        this.imageUrl = imageUrl;
//        this.ratings = ratings;
//        this.reviews = reviews;
//        this.numRatings = numRatings;
//        this.category = category;
//        this.createdAt = createdAt;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getDiscountPrice() {
//        return discountPrice;
//    }
//
//    public void setDiscountPrice(int discountPrice) {
//        this.discountPrice = discountPrice;
//    }
//
//    public int getDiscountPresent() {
//        return discountPresent;
//    }
//
//    public void setDiscountPresent(int discountPresent) {
//        this.discountPresent = discountPresent;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Set<Size> getSizes() {
//        return sizes;
//    }
//
//    public void setSizes(Set<Size> sizes) {
//        this.sizes = sizes;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public List<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(List<Rating> ratings) {
//        this.ratings = ratings;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public int getNumRatings() {
//        return numRatings;
//    }
//
//    public void setNumRatings(int numRatings) {
//        this.numRatings = numRatings;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//}

















package com.kishi.ecommerce_api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "discounted_price")
    private int discountPrice;

    // Corrected field name for discount percentage
    @Column(name = "discount_percent")
    private int discountPersent;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    // Element collection for sizes with CollectionTable annotation
//    @ElementCollection
//    @CollectionTable(
//            name = "product_sizes",
//            joinColumns = @JoinColumn(name = "product_id")
//    )
//    private Set<Size> sizes = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "product_sizes",
            joinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Size> sizes = new HashSet<>();

    @Column(name = "image_url")
    private String imageUrl;

    // OneToMany relationship with Rating, orphanRemoval is enabled
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    // OneToMany relationship with Review, orphanRemoval is enabled
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @Column(name = "num_ratings")
    private int numRatings;

    // ManyToOne relationship with Category, using lazy fetching
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    // Created at timestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    public Product() {
    }

    public Product(Long id, String title, String description, int price, int discountPrice, int discountPersent, int quantity, String brand, String color, Set<Size> sizes, String imageUrl, List<Rating> ratings, List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.discountPersent = discountPersent;
        this.quantity = quantity;
        this.brand = brand;
        this.color = color;
        this.sizes = sizes;
        this.imageUrl = imageUrl;
        this.ratings = ratings;
        this.reviews = reviews;
        this.numRatings = numRatings;
        this.category = category;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountPersent() {
        return discountPersent;
    }

    public void setDiscountPersent(int discountPercent) {
        this.discountPersent = discountPersent;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Size> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


