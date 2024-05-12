package com.spring.threedomains.rest;

import com.spring.threedomains.request.ProductDetailHistoryRequest;
import com.spring.threedomains.service.ProductDetailHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productdetailhistory")
public class ProductDetailHistoryRest {
    @Autowired
    ProductDetailHistoryService service;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDetailHistoryRequest productDetailHistory){
        return ResponseEntity.ok(service.add(productDetailHistory));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getAllById(id));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getbyid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
