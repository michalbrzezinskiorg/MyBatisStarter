package com.example.demo.database;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersDAO {

    @Insert({"insert into users (name, surname, profile) values (#{name}, #{surname}, #{profile})"})
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    long insert(User user);

    @Update("update users set name = #{name}, surname = #{surname}, " +
            "profile = #{profile} where id = #{id}")
    void update(User user);

    @Select("select id, name, surname, profile from users where id = #{id}")
    User findById(long id);

    @Select("select * from users")
    List<User> findAll();

}
