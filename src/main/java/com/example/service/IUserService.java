package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.dto.UserAddDto;
import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.UserVo;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author jobob
 * @since 2022-01-21
 */
public interface IUserService extends IService<User> {


    IPage<UserVo> userList(IPage<UserVo> articlePage);

    int userAdd( String name, Integer age);
//    Boolean userAdd(UserAddDto userAddDto);


    int userDel( Integer id);


}
