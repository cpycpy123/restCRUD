package com.example.restfulcrud.controller;

import com.example.restfulcrud.model.Account;
import com.example.restfulcrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account findById(@PathVariable("id") int id){
        return accountService.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name",required = true) String name,
                                @RequestParam(value = "money",required = true) double money){
        int t = accountService.update(name,money,id);
        if (t==1){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        int i  = accountService.delete(id);
        if (i==1){
            return "success";
        }else {
            return "fail";
        }
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name") String name,@RequestParam(value = "money") double money){
        int i = accountService.add(name,money);
        if (i==1){
            return "success";
        }else {
            return "fail";
        }
    }
}
