package com.spring.threedomains.rest;

import com.spring.threedomains.request.ImageRequest;
import com.spring.threedomains.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/image")
public class ImageRest {
    @Autowired
    ImageService service;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ImageRequest image){
        return ResponseEntity.ok(service.add(image));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/1/{id}")
    public ResponseEntity<?> delete1(@PathVariable("id") Integer id){
        service.delete1(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
