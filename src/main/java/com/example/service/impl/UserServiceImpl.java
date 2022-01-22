package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2022-01-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserVo> userList(IPage<UserVo> articlePage) {
        return userMapper.userList(articlePage);
    }

    @Override
    public int userAdd(String username, Integer age) {
        return userMapper.userAdd(username, age);
    }

    @Override
    public int userDel(Integer id) {
        return userMapper.userDel(id);
    }

}
