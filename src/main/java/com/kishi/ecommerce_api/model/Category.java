//package com.kishi.ecommerce_api.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//@Entity
//public class Category {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    @Size(max=50)
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_category_id")
//    private Category parentCategory;
//
//    private int level;
//
//    public Category(){
//
//    }
//
//    public Category(Long id, String name, Category parentCategory, int level) {
//        this.id = id;
//        this.name = name;
//        this.parentCategory = parentCategory;
//        this.level = level;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Category getParentCategory() {
//        return parentCategory;
//    }
//
//    public void setParentCategory(Category parentCategory) {
//        this.parentCategory = parentCategory;
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }
//}




package com.kishi.ecommerce_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @jakarta.validation.constraints.Size(max = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    private int level;

    public Category() {
        // Default constructor for JPA
    }

    public Category(Long id, String name, Category parentCategory, int level) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
        this.level = level;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
