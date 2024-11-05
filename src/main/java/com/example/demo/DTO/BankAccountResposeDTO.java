package com.example.demo.DTO;

import com.example.demo.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BankAccountResposeDTO {

    private String id ;
    private Date date ;
    private Double balance;
    private String currency ;
    private AccountType accountType;
}
