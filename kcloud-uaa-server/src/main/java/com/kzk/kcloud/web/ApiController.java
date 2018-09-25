package com.kzk.kcloud.web;

import com.kzk.kcloud.model.User;
import com.kzk.kcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UserService userService;

    @RequestMapping("/userinfo")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(String username){
        User user = (User)userService.loadUserByUsername(username);
        return ResponseEntity.ok(user);
    }
}
