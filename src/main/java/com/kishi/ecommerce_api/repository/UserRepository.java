package com.kishi.ecommerce_api.repository;

import com.kishi.ecommerce_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);

}
