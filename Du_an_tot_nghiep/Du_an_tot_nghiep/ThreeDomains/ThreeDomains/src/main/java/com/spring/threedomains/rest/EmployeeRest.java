package com.spring.threedomains.rest;

import com.spring.threedomains.request.CapNhatProfile;
import com.spring.threedomains.request.EmployeeRequest;
import com.spring.threedomains.request.ForgetForm;
import com.spring.threedomains.service.EmployeeService;
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
@RequestMapping("/api/employee")
public class EmployeeRest {

    @Autowired
    EmployeeService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/getall1")
    public ResponseEntity<?> getAll1(){
        return ResponseEntity.ok(service.getAll1());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> getAllByEmployee(@PathVariable("name") String name){
        return ResponseEntity.ok(service.getAllbyName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody EmployeeRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.add(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer Id, @Valid @RequestBody EmployeeRequest request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.update(Id,request));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer Id){
        return ResponseEntity.ok(service.delete(Id));
    }
    @PutMapping("/khoiphuc/{id}")
    public ResponseEntity<?> khoiphuc(@PathVariable("id") Integer Id){
        return ResponseEntity.ok(service.delete1(Id));
    }
    @GetMapping("/getByUsername/{usernmae}")
    public ResponseEntity<?> getByUsername(@PathVariable("usernmae") String name){
        return ResponseEntity.ok(service.getByUsername(name));
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

    @PutMapping("/updateprofile/{id}")
    public ResponseEntity<?> updateprofile(@PathVariable("id") Integer id, @Valid @RequestBody CapNhatProfile form, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.updateprofile(id,form));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getAllByFilter(@RequestParam(name = "idRole",required = false) Integer idRole){
        return ResponseEntity.ok(service.getAllByFilter(idRole));
    }




}
