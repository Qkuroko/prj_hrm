package com.glb.controller;

import com.glb.entity.Staff;
import com.glb.dto.ResponseDTO;
import com.glb.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录注册接口
 *
 * @Author : glb
 * @Date : 2022/1/30
 */
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody Staff staff) {
        return this.loginService.login(staff);
    }
}
