package com.example.restfulcrud.service;

import com.example.restfulcrud.dao.AccountMapper;
import com.example.restfulcrud.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name,Double money){
        return accountMapper.add(name,money);
    }

    public int update(String name,Double money,int id){
        return accountMapper.update(name,money,id);
    }

    public int delete(int id){
        return accountMapper.delete(id);
    }
    public Account findById(int id){
        return accountMapper.findById(id);
    }

    public List<Account> findAll(){
        return accountMapper.findAll();
    }
}
