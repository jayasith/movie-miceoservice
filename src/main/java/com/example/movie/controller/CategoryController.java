package com.example.movie.controller;

import com.example.movie.controller.request.CategoryRequest;
import com.example.movie.persistence.entity.Category;
import com.example.movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v0.1/product/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public void add(CategoryRequest request){
        categoryService.addCategory(request);
    }

    @GetMapping("/get")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
}
