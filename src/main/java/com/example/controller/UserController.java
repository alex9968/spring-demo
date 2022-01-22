package com.example.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.service.IUserService;
import com.example.entity.User;
import com.example.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("")
    @ResponseBody
    public CommonResult getList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("size");
        if (name == "") {
            return CommonResult.failed("验证码不正确");
        }

        for (User user : userService.list()) {
            System.out.println(user.getName());
        }
        return CommonResult.success(userService.list(), "success");
    }


    @DeleteMapping("")
    @ResponseBody
    public CommonResult delUser(HttpServletRequest request, Integer id) {
        userService.removeById(id);
        return CommonResult.success("删除成功");
    }

    @PostMapping("")
    @ResponseBody
    public CommonResult addUser(HttpServletRequest request) {
        String username=request.getParameter("username");
        String  ageStr = request.getParameter("age");
        Integer age = Integer.parseInt(ageStr);

        userService.userAdd(username, age);
        return CommonResult.success("添加成功");
    }
}