package com.example.movie.service;

import com.example.movie.controller.request.CategoryRequest;
import com.example.movie.persistence.CategoryPersistence;
import com.example.movie.persistence.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryPersistence categoryPersistence;

    @Autowired
    public CategoryService(CategoryPersistence categoryPersistence) {
        this.categoryPersistence = categoryPersistence;
    }

    public void addCategory(CategoryRequest request){
        Category category = Category.builder()
                .name(request.getName())
                .build();

        categoryPersistence.addCategory(category);
    }

    public List<Category> getAll(){
        return categoryPersistence.getAll();
    }

}
