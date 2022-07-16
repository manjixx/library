package com.example.library.service;

import com.example.library.dao.BookDAO;
import com.example.library.pojo.Book;
import com.example.library.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：
 * Date：2022/7/1611:41
 * Desc:
 */
@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        return bookDAO.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public void addOrUpdate(Book book){
    // save() 方法的作用是，当主键存在时更新数据，当主键不存在时插入数据。
        bookDAO.save(book);
    }

    public void deleteById(int id){
        bookDAO.deleteById(id);
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> Search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
