package com.example.library.service;

import com.example.library.dao.CategoryDAO;
import com.example.library.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：
 * Date：2022/7/1611:34
 * Desc:
 */
@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list(){
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public Category get(int id) {
        Category category= categoryDAO.findById(id).orElse(null);
        return category;
    }
}
