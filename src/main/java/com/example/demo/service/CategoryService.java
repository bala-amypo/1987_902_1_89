package com.example.backendproject.service;

import com.example.backendproject.model.Category;
import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategory(Long id);

    List<Category> getAllCategories();
}

