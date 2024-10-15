package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.UserException;
import com.kishi.ecommerce_api.model.User;




public interface UserService  {
    public User findUserBYId(Long userId)throws UserException;
    public User findUserProfileJwt(String jwt)throws UserException;
}
