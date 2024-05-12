package com.spring.threedomains.service;

import com.spring.threedomains.entity.Customer;
import com.spring.threedomains.entity.ProductDetail;
import com.spring.threedomains.entity.Rating;
import com.spring.threedomains.repository.RatingRepository;
import com.spring.threedomains.request.DanhGiaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingService {
    @Autowired
    RatingRepository repository;

    public Rating add(DanhGiaRequest request){
        Rating rating = new Rating();
        rating.setScore(request.getScore());
        rating.setNote(request.getNote());
         rating.setCreateDate(new Date());
         rating.setCustomer(Customer.builder().Id(request.getIdCustomer()).build());
         rating.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
         rating.setStatus(0);
         return repository.save(rating);
    }
}
