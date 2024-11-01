package com.example.demo.Repositories;

import com.example.demo.entity.BankAccount;
import com.example.demo.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "byType")
    List<BankAccount> findByAccountType(@Param("t") AccountType type);
}
