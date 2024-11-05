package com.example.demo.entity;

import com.example.demo.enums.AccountType;
import jakarta.persistence.*;
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
    @ManyToOne
    private Customer customer;

}
