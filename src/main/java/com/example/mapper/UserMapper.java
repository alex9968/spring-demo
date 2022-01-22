package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2022-01-21
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    IPage<UserVo> userList(IPage<UserVo> articlePage);

    int userAdd( @Param("name") String username, @Param("age") Integer age);

    int userDel(  @Param("id") Integer age);


}
