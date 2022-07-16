package com.example.library.dao;

import com.example.library.pojo.Book;
import com.example.library.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author：
 * Date：2022/7/1611:22
 * Desc:
 */
public interface BookDAO extends JpaRepository<Book,Integer> {
    // 能使用findAllByCategory()是因为Book类中有@JoinColumn
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String title,String author);
}
