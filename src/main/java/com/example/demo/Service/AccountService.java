package com.example.demo.Service;

import com.example.demo.DTO.BankAccountRequestDTO;
import com.example.demo.DTO.BankAccountResposeDTO;

public interface AccountService {
    public BankAccountResposeDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}

