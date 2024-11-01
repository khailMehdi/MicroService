package com.example.demo.entity;

import com.example.demo.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class , name = "p1")
public interface AccountProjection  {
    public String getId();
    public AccountType getAccountType();
}
