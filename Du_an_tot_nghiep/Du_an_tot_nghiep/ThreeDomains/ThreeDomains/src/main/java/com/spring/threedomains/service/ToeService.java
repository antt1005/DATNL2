package com.spring.threedomains.service;

import com.spring.threedomains.entity.Toe;
import com.spring.threedomains.repository.ToeRepository;
import com.spring.threedomains.request.ToeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ToeService {
    @Autowired
    ToeRepository repository;
    @Cacheable(value = "toeCache", key = "'getAll'")
    public List<Toe> getAll(){
        return repository.getAll();
    }
    @Cacheable(value = "toeCache", key = "#name")
    public List<Toe> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    @Transactional
    @CachePut(value = "toeCache", key = "#request.name")
    @CacheEvict(value = "toeCache", key = "'getAll'", allEntries = true)
    public Toe add(ToeRequest request){
        Toe toe = new Toe();
        toe.setDescription(request.getDescription());
        toe.setName(request.getName());
        toe.setCreateDate(new Date());
        toe.setStatus(0);
        return repository.save(toe);
    }
    @Transactional
    @CachePut(value = "toeCache", key = "#request.name")
    @CacheEvict(value = "toeCache", key = "'getAll'", allEntries = true)
    public Toe update(Integer Id,ToeRequest request){
        Toe toe = repository.getById(Id);
        toe.setDescription(request.getDescription());
        toe.setName(request.getName());
        toe.setUpdateDate(new Date());
        return repository.save(toe);
    }
    @Transactional
    @CacheEvict(value = "toeCache", key = "'getAll'", allEntries = true)
    public Toe delete(Integer Id){
        Toe toe = repository.getById(Id);
        toe.setStatus(1);
        return repository.save(toe);
    }
    @Cacheable(value = "toeCache", key = "#Id")
    public Toe getById(Integer Id){
        Toe toe = repository.getById(Id);
        return toe;
    }
}
