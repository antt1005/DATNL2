package com.spring.threedomains.service;

import com.spring.threedomains.entity.ReturnExchangeDetail;
import com.spring.threedomains.repository.ReturnChangeDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnChangeDetailService {

    @Autowired
    ReturnChangeDetailRepo repo;


    public List<ReturnExchangeDetail> getById(Integer id){
        return repo.findAll();
    }

}
