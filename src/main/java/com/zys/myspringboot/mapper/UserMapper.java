package com.zys.myspringboot.mapper;

import com.zys.myspringboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user_name (name, account_id, token, ac_Token, gmt_create, gmt_modified, bio, avatar_url) values (#{name}, #{accountId}, #{token}, #{accessToken}, #{gmtCreate}, #{gmtModified}, #{bio}, #{avatarUrl})")
    void insert(User user);
    @Select("select * from user_name where token = #{token}")
    User findByToken(@Param("token") String token);
}
