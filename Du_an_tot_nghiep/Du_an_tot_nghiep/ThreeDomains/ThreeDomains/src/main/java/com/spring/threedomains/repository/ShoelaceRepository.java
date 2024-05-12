package com.spring.threedomains.repository;

import com.spring.threedomains.entity.Shoelace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoelaceRepository extends JpaRepository<Shoelace,Integer> {
    @Query(value = "Select e from Shoelace e where e.Status = 0 order by e.CreateDate desc ")
    public List<Shoelace> getAll();
    @Query(value = "Select e from Shoelace e where e.Status = 0 and e.Name like :name")
    public List<Shoelace> searchByName(@Param("name") String name);
    @Query(value = "select e from Shoelace e where e.Id = :id")
    public Shoelace getById(@Param("id") Integer Id);
}
