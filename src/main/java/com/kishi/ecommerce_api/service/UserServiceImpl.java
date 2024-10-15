package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.config.JwtProvider;
import com.kishi.ecommerce_api.exception.UserException;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository,JwtProvider jwtProvider){
        this.userRepository=userRepository;
        this.jwtProvider=jwtProvider;

    }

    @Override
    public User findUserBYId(Long userId) throws UserException {
        Optional<User>user=userRepository.findById(userId);
        if (user.isPresent()){
            return user.get();
        }
        throw new UserException("user not found with id :"+userId);
    }

    @Override
    public User findUserProfileJwt(String jwt) throws UserException {
        String email= jwtProvider.getEmailFromToken(jwt);
        User user=userRepository.findByEmail(email);
        if(user == null){
            throw new UserException("user not found with email "+email);
        }
        return user;
    }
}
