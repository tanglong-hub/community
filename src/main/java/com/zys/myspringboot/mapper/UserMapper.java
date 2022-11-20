package com.zys.myspringboot.mapper;

import com.zys.myspringboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user_name (name, account_id, token, ac_Token, gmt_create, gmt_modified, bio) values (#{name}, #{accountId}, #{token}, #{accessToken}, #{gmtCreate}, #{gmtModified}, #{bio})")
    void insert(User user);
}
