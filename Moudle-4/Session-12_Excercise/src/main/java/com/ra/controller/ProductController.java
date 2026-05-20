package com.ra.controller;

import com.ra.model.dto.product.ProductRequest;
import com.ra.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> listProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequest productRequest, @PathVariable Long id){
        return ResponseEntity.ok(productService.updateProduct(productRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
