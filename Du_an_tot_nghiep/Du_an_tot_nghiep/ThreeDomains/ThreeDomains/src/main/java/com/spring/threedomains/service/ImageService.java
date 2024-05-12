package com.spring.threedomains.service;

import com.spring.threedomains.entity.Product;
import com.spring.threedomains.entity.ProductImage;
import com.spring.threedomains.repository.ProductImageRepository;
import com.spring.threedomains.request.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    ProductImageRepository repository;

    public ProductImage add(ImageRequest image){
        ProductImage productImage = new ProductImage();
        productImage.setUrl(image.getUrl());
        productImage.setMainImage(image.getMainImage());
        productImage.setProduct(Product.builder().Id(image.getIdProduct()).build());
        productImage.setCreateDate(new Date());
        productImage.setStatus(0);
        return repository.save(productImage);
    }
    public void delete(Integer IdProduct){
        List<ProductImage> list = repository.getAllByIdSP(IdProduct);
        for(ProductImage p : list){
            repository.delete(p);
        }
    }
    public void delete1(Integer IdProduct){
        List<ProductImage> list = repository.getAllByIdSP1(IdProduct);
        for(ProductImage p : list){
            repository.delete(p);
        }
    }
}
