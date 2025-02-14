package com.spring.threedomains.service;

import com.spring.threedomains.entity.Voucher;
import com.spring.threedomains.repository.GetVoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVoucherService {
    @Autowired
    private GetVoucherRepo repo ;

    public List<Voucher> getAll(){
        return repo.getAll();
    }
}
