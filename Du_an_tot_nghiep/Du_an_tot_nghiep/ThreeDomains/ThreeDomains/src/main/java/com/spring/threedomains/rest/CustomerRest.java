package com.spring.threedomains.rest;

import com.spring.threedomains.request.CapNhatProfile;
import com.spring.threedomains.request.CustomerReques;
import com.spring.threedomains.request.ForgetForm;
import com.spring.threedomains.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerRest {
    @Autowired
    CustomerService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/getall1")
    public ResponseEntity<?> getAll1(){
        return ResponseEntity.ok(service.getAll1());
    }

    @GetMapping("/search/{fullname}")
    public ResponseEntity<?> getAllByProductName(@PathVariable("fullname") String fullname){
        return ResponseEntity.ok(service.getAllbyFullName(fullname));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody CustomerReques request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.add(request));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer Id,@Valid @RequestBody CustomerReques request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.update(Id,request));
    }
    @PutMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Integer id ){
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/khoiphuc/{id}")
    public  ResponseEntity<?> khoiphuc(@PathVariable("id") Integer id ){
        return ResponseEntity.ok(service.delete1(id));
    }


    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(service.getByUsername(username));
    }
    @PutMapping("/updateprofile/{id}")
    public ResponseEntity<?> updateprofile(@PathVariable("id") Integer id, @Valid @RequestBody CapNhatProfile form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.updateprofile(id,form));
    }
    @PutMapping("/forget")
    public ResponseEntity<?> forget(@Valid @RequestBody ForgetForm form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        if(!form.getEmail().equals(service.getByUsername(form.getUsername()).getEmail())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("err");
        }
        return ResponseEntity.ok(service.forget(form));
    }
    @GetMapping("/checkdkdanhgia")
    public ResponseEntity<?> checkdkdanhgia(@RequestParam("IdCustomer") Integer IdCustomer,
                                            @RequestParam("IdProductDetail") Integer IdProductDetail){
        return ResponseEntity.ok(service.checkdk(IdCustomer,IdProductDetail));
    }

}
