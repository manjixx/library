package com.example.library.dao;


import com.example.library.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author：
 * Date：2022/7/1611:23
 * Desc:
 */

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    // 不需要提供额外方法，JPA提供的方法足够了
}
