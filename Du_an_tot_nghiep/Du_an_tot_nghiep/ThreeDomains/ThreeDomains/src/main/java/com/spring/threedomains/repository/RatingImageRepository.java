package com.spring.threedomains.repository;

import com.spring.threedomains.entity.RatingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingImageRepository extends JpaRepository<RatingImage,Integer> {
}
