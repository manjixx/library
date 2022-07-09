package com.example.libary.controller;

import com.example.libary.pojo.User;
import com.example.libary.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * Author：
 * Date：2022/7/914:51
 * Desc:
 */
@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUserName();

        username = HtmlUtils.htmlEscape(username);

        if(!Objects.equals("admin",username) || !Objects.equals("123456",requestUser.getPassWord())){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

}
