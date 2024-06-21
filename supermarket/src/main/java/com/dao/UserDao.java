package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {
    @Select("select * from user where username = #{username}")
    User selectByName(String username);

//    @Insert("insert into user values(#{id},#{username},#{password},#{img}) ")
//    Integer insertUser(User user);

    @Select("select * from user where id = #{id}")
    User selectById(int id);

    @Update("update user set username=#{username},password=#{password},img=#{img} where id=#{id}")
    void updateById(User user);

}
