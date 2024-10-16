package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.CartItemException;
import com.kishi.ecommerce_api.exception.UserException;
import com.kishi.ecommerce_api.model.Cart;
import com.kishi.ecommerce_api.model.CartItem;
import com.kishi.ecommerce_api.model.Product;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.repository.CartItemRepository;
import com.kishi.ecommerce_api.repository.CartRepository;
import com.kishi.ecommerce_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{

    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository cartRepository;


    public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountPrice()* cartItem.getQuantity());

        CartItem createdCartItem=cartItemRepository.save(cartItem);

        return createdCartItem;
    }



    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {

        CartItem item =findCartItemById(id);
        User user =userService.findUserBYId(item.getUserId());
        if(user.getId().equals(userId)){
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getProduct().getPrice()* item.getQuantity());
            item.setDiscountedPrice(item.getProduct().getDiscountPrice()* item.getQuantity());
        }

        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExist(cart,product,size,userId);

        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = findCartItemById(cartItemId);
        User user =userService.findUserBYId(cartItem.getUserId());
        User reqUser = userService.findUserBYId(userId);
        if(user.getId().equals(reqUser.getId())){
            cartItemRepository.deleteById(cartItemId);
        }else{
            throw new UserException("you can't remove another users item");
        }

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem>opt=cartItemRepository.findById(cartItemId);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new CartItemException("cartItem not found with id:");
    }
}
