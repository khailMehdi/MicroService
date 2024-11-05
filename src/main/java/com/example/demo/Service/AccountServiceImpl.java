package com.example.demo.Service;

import com.example.demo.DTO.BankAccountRequestDTO;
import com.example.demo.DTO.BankAccountResposeDTO;
import com.example.demo.Repositories.BankAccountRepository;
import com.example.demo.entity.BankAccount;
import com.example.demo.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class AccountServiceImpl implements AccountService{

    public AccountServiceImpl(AccountMapper accountMapper, BankAccountRepository bankAccountRepository) {
        this.accountMapper = accountMapper;
        this.bankAccountRepository = bankAccountRepository;
    }

    private AccountMapper accountMapper;
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResposeDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .date(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency()).build();
        BankAccount saveBankAccount =bankAccountRepository.save(bankAccount);
        BankAccountResposeDTO bankAccountResposeDTO=accountMapper.forBankAccount(saveBankAccount);
        return bankAccountResposeDTO;
    }
}
