package com.example.demo;

import com.example.demo.Repositories.BankAccountRepository;
import com.example.demo.entity.BankAccount;
import com.example.demo.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Bean
    CommandLineRunner start (BankAccountRepository bankAccountRepository){
        return args ->{
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount= BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*900).date(new Date())
                        .currency("MAD").build() ;
                bankAccountRepository.save(bankAccount);
                System.out.println("***> "+bankAccount);
            }
        };
    }

}
