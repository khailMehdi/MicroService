package com.example.demo.web;

import com.example.demo.DTO.BankAccountRequestDTO;
import com.example.demo.DTO.BankAccountResposeDTO;
import com.example.demo.Repositories.BankAccountRepository;
import com.example.demo.Service.AccountService;
import com.example.demo.entity.BankAccount;
import com.example.demo.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AcountRestController {

    private BankAccountRepository bankAccountRepository;
@Autowired
    private AccountMapper accountMapper;


@Autowired
    private AccountService accountService;
    public AcountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResposeDTO save(@RequestBody BankAccountRequestDTO requestDTO) {

        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getDate() != null) account.setDate(new Date());
        if (bankAccount.getAccountType() != null) account.setAccountType(bankAccount.getAccountType());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
