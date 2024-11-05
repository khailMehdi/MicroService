package com.example.demo.web;

import com.example.demo.DTO.BankAccountRequestDTO;
import com.example.demo.DTO.BankAccountResposeDTO;
import com.example.demo.Repositories.BankAccountRepository;
import com.example.demo.Service.AccountService;
import com.example.demo.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGrfQl {

    @Autowired
    private BankAccountRepository bankAccountRepository;
@Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }


    @QueryMapping
    public BankAccount bankaccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account not found")));
    }
@MutationMapping
public BankAccountResposeDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
   return accountService.addAccount(bankAccount);
}

}
