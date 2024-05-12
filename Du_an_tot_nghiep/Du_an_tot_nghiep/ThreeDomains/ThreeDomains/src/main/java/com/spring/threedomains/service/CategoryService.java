package com.spring.threedomains.service;

import com.spring.threedomains.entity.Category;
import com.spring.threedomains.repository.CategoryRepository;
import com.spring.threedomains.request.CategoryRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;
    @Cacheable(value = "categoryCache", key = "'getAll'")
    public List<Category> getAll(){
        return repository.getAll();
    }
    @Cacheable(value = "categoryCache", key = "#name")
    public List<Category> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    @Transactional
    @CachePut(value = "categoryCache", key = "#request.name")
    @CacheEvict(value = "categoryCache", key = "'getAll'", allEntries = true)
    public Category add(CategoryRequest request){
        Category category = new Category();
        category.setDescription(request.getDescription());
        category.setName(request.getName());
        category.setCreateDate(new Date());
        category.setStatus(0);
        return repository.save(category);
    }
    @Transactional
    @CachePut(value = "categoryCache", key = "#request.name")
    @CacheEvict(value = "categoryCache", key = "'getAll'", allEntries = true)
    public Category update(Integer Id,CategoryRequest request){
        Category category = repository.getById(Id);
        category.setDescription(request.getDescription());
        category.setName(request.getName());
        category.setUpdateDate(new Date());
        return repository.save(category);
    }
    @Transactional
    @CacheEvict(value = "categoryCache", key = "'getAll'", allEntries = true)
    public Category delete(Integer Id){
        Category category = repository.getById(Id);
        category.setStatus(1);
        return repository.save(category);
    }
    @Cacheable(value = "categoryCache", key = "#Id")
    public Category getById(Integer Id){
        Category category = repository.getById(Id);
        return category;
    }
}
