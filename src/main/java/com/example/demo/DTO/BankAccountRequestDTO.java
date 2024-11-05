package com.example.demo.DTO;

import com.example.demo.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccountRequestDTO {

    private Double balance;
    private String currency ;
    private AccountType accountType;
}
