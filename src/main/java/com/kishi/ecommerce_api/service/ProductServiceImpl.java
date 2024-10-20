package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.ProductException;
import com.kishi.ecommerce_api.model.Category;
import com.kishi.ecommerce_api.model.Product;
import com.kishi.ecommerce_api.repository.CategoryRepository;
import com.kishi.ecommerce_api.repository.ProductRepository;
import com.kishi.ecommerce_api.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private UserService userService;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public Product createProduct(CreateProductRequest req) {
        Category toplevel = categoryRepository.findByName(req.getTopLevelCategory());
        if(toplevel ==null){
            Category topLevelCategory=new Category();
            topLevelCategory.setName(req.getTopLevelCategory());
            topLevelCategory.setLevel(1);

            toplevel=categoryRepository.save(topLevelCategory);
        }

        Category secondlevel = categoryRepository.findByName(req.getSecondLevelCategory());
        if(secondlevel ==null){
            Category secondLevelCategory=new Category();
            secondLevelCategory.setName(req.getTopLevelCategory());
            secondLevelCategory.setLevel(2);

            secondlevel=categoryRepository.save(secondLevelCategory);
        }

        Category thirdLevel = categoryRepository.findByName(req.getThirdLevelCategory());
        if(thirdLevel ==null){
            Category thirdLevelCategory=new Category();
            thirdLevelCategory.setName(req.getTopLevelCategory());
            thirdLevelCategory.setLevel(2);

            thirdLevel=categoryRepository.save(thirdLevelCategory);
        }

        Product product=new Product();

        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setDescription(req.getDescription());
        product.setDiscountPrice(req.getDiscountedPrice());
        product.setDiscountPersent(req.getDiscountPersent());
        product.setImageUrl(req.getImageUrl());
        product.setBrand(req.getBrand());
        product.setSizes(req.getSize());
        product.setQuantity(req.getQuantity());
        product.setCategory(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());

        Product savedProduct =productRepository.save(product);


        return savedProduct;
    }



    @Override
    public String deleteProduct(Long productId) throws ProductException {

        Product product=findProductById(productId);
        product.getSizes().clear();
        productRepository.delete(product);
        return "Product deleted Successfully";
    }

    @Override
    public Product updateProduct(Long productId, Product req) throws ProductException {
        Product product=findProductById(productId);

        if(req.getQuantity()!=0){
            product.setQuantity(req.getQuantity());

        }
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        Optional<Product> opt = productRepository.findById(id);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new ProductException("product not found with id -"+id);
    }
    @Override
    public List<Product> findProductByCategory(String category) {
        return null;
    }

    @Override
    public Page<Product> getAllProduct(String category,
                                       List<String> colors,
                                       List<String> sizes,
                                       Integer minPrice,
                                       Integer maxPrice,
                                       Integer minDiscount,
                                       String sort,
                                       String stock,
                                       Integer pageNumber,
                                       Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        List<Product> products = productRepository.filterProducts(category,minPrice,maxPrice,minDiscount,sort);
        if(!colors.isEmpty()){
            products=products.stream().filter(p->colors.stream().anyMatch(c->c.equalsIgnoreCase(p.getColor())))
                    .collect(Collectors.toList());
        }

        if(stock!=null){
            if(stock.equals("in_stock")){
                products=products.stream().filter(p->p.getQuantity()>0).collect(Collectors.toList());
            } else if (stock.equals("out_of_stock")) {
                products=products.stream().filter(p->p.getQuantity()<1).collect(Collectors.toList());

            }
        }

        int startIndex =(int) pageable.getOffset();
        int endIndex =Math.min(startIndex+pageable.getPageSize(),products.size());

        List<Product>pageContent=products.subList(startIndex,endIndex);

        Page<Product>filterProducts =new PageImpl<>(pageContent,pageable,products.size());



        return filterProducts;
    }
}