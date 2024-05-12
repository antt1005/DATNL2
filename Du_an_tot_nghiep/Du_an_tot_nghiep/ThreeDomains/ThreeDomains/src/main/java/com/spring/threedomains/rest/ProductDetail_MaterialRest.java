package com.spring.threedomains.rest;

import com.spring.threedomains.request.ProductDetail_MaterialRequest;
import com.spring.threedomains.service.ProductDetail_MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productdetail_material")
public class ProductDetail_MaterialRest {
    @Autowired
    ProductDetail_MaterialService service;


    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductDetail_MaterialRequest request){
        return ResponseEntity.ok(service.add(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok("ok");
    }
}
