package com.example.restfulcrud.dao;

import com.example.restfulcrud.model.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    @Insert("insert into account(name,money) values(#{name},#{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    int update(@Param("name") String name,@Param("money") double money,@Param("id") int id);

    @Delete("delete from account where id=#{id}")
    int delete(int id);

    @Select("select id,name as name,money as money from account where id = #{id}")
    Account findById(@Param("id") int id);

    @Select("select * from Account")
    List<Account> findAll();
}
