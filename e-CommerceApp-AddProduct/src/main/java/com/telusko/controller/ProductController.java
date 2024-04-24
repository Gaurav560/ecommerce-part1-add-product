package com.telusko.controller;

import com.telusko.model.Product;
import com.telusko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;



    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestPart("product") Product product,
                                           @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            System.out.println(product.isProductAvailable());
            Product savedProduct = productService.createProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






//
//    {
//        "name": "Example Product",
//            "description": "This is a detailed description of the example product.",
//            "brand": "ExampleBrand",
//            "price": 19.99,
//            "category": "Electronics",
//            "stockQuantity": 100,
//            "releaseDate": "2024-04-17",
//            "productAvailable": true
//    }

}
