package com.spring.threedomains.authention;

import com.spring.threedomains.entity.Customer;
import com.spring.threedomains.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomerService service;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        String token = null;
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        // Xác thực thông tin đăng nhập ở đây (ví dụ: kiểm tra tên người dùng và mật khẩu)
        // Nếu xác thực thành công, phát sinh mã JWT và trả về cho người dùng
        Customer customer = service.getByUsername(loginRequest.getUsername());
        if (customer == null){
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");

        }
        if (!customer.getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");
        }
        if(customer.getStatus() != 0){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");
        }

        token = jwtTokenUtil.generateToken(loginRequest.getUsername());
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        tokenMap.put("token",token);
        tokenMap.put("user",customer);
        return new ResponseEntity<Map<String,Object>>(tokenMap,HttpStatus.OK);
    }
    @GetMapping(value = "/get")
    public ResponseEntity<?> getByToken(@RequestParam("token") String token) {
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        tokenMap.put("username",jwtTokenUtil.getUsernameFromToken(token));
        return new ResponseEntity<Map<String,Object>>(tokenMap,HttpStatus.OK);
    }
}
