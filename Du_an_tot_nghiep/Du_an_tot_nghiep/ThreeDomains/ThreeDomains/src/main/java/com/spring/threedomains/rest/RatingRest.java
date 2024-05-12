package com.spring.threedomains.rest;

import com.spring.threedomains.request.DanhGiaRequest;
import com.spring.threedomains.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rating")
public class RatingRest {
    @Autowired
    RatingService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody DanhGiaRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
