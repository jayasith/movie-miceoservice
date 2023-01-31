package com.example.movie.persistence;

import com.example.movie.persistence.entity.Category;
import com.example.movie.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryPersistence {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryPersistence(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}
