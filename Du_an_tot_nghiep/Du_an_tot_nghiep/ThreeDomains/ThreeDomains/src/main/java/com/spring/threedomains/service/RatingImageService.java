package com.spring.threedomains.service;

import com.spring.threedomains.entity.Rating;
import com.spring.threedomains.entity.RatingImage;
import com.spring.threedomains.repository.RatingImageRepository;
import com.spring.threedomains.request.RatingImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingImageService {
    @Autowired
     RatingImageRepository repository;

    public RatingImage add(RatingImageRequest request){
        RatingImage ratingImage = new RatingImage();
        ratingImage.setUrl(request.getUrl());
        ratingImage.setRating(Rating.builder().Id(request.getIdRating()).build());
        return repository.save(ratingImage);
    }
}
