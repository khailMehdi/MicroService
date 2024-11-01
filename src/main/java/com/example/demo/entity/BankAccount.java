package com.example.demo.entity;

import com.example.demo.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
public class BankAccount {
    @Id
    private String id ;
    private Date date ;
    private Double balance;
    private String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
