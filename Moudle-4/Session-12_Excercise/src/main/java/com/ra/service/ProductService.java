package com.ra.service;

import com.ra.exception.BadRequestException;
import com.ra.model.dto.product.ProductRequest;
import com.ra.model.entity.Product;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public String createProduct(ProductRequest request){


        if(request == null) return null;

        Product newProduct = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .size(request.getSize())
                .toppings(request.getToppings())
                .build();
        productRepository.save(newProduct);

        return "Thêm mới sản phẩm thành công";
    }

    public String updateProduct(ProductRequest request, Long id){
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(()->new BadRequestException("Không tìm thấy sản phẩm có mã là: " + id));

        updateProduct.setName(request.getName());
        updateProduct.setDescription(request.getDescription());
        updateProduct.setPrice(request.getPrice());
        updateProduct.setSize(request.getSize());
        updateProduct.setToppings(request.getToppings());

        productRepository.save(updateProduct);

        return "Cập nhật sản phẩm thành công";
    }

    public String deleteProduct(Long id){
        Product deleteProduct = productRepository.findById(id)
                .orElseThrow(()->new BadRequestException("Không tìm thấy sản phẩm có mã là: " + id));

        productRepository.delete(deleteProduct);

        return "Xóa sản phẩm thành công";
    }
}
