package com.example.library.dao;

import com.example.library.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author：
 * Date：2022/7/919:19
 * Desc:
 */
public interface UserDAO extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

}
