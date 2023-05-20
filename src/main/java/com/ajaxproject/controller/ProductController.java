package com.ajaxproject.controller;

import com.ajaxproject.model.Product;
import com.ajaxproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> list() {
        return productService.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.get(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }


}
