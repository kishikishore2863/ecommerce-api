package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.ProductException;
import com.kishi.ecommerce_api.model.Cart;
import com.kishi.ecommerce_api.model.CartItem;
import com.kishi.ecommerce_api.model.Product;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.repository.CartRepository;
import com.kishi.ecommerce_api.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;


    public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        Cart cart =cartRepository.findByUserId(userId);
        Product product =productService.findProductById(req.getProductId());
        CartItem isPresent =cartItemService.isCartItemExist(cart,product, req.getSize(), userId);
        if(isPresent ==null){
            CartItem cartItem =new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setUserId(userId);

            int price =req.getQuantity()*product.getDiscountPrice();
            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem)
        }
        return  "item Added to cart";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart   =cartRepository.findByUserId(userId);
        int totalPrice=0;
        int totalItem=0;
        int totalDiscountedPrice=0;

        for(CartItem cartItem:cart.getCartItems()){
            totalPrice=totalPrice+cartItem.getPrice();
            totalDiscountedPrice=totalDiscountedPrice+ cartItem.getDiscountedPrice();
            totalItem=totalItem+cartItem.getQuantity();
        }

        cart.setTotalItem(totalItem);
        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountedPrice(totalPrice-totalDiscountedPrice);


        return cartRepository.save(cart);
    }
}
