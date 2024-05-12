package com.spring.threedomains.service;

import com.spring.threedomains.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CheckVoucherExpiredService {
    @Autowired
    VoucherRepository repository;
    @Scheduled(cron = "0 0 0 * * *")
    public void updateExpiredDiscounts() {
        System.out.println("Đã check voucher hết hạn");
        repository.updateExpensive();
    }
}
