package com.example.demo.mappers;

import com.example.demo.DTO.BankAccountRequestDTO;
import com.example.demo.DTO.BankAccountResposeDTO;
import com.example.demo.entity.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResposeDTO forBankAccount(BankAccount bankAccount){
   BankAccountResposeDTO bankAccountResposeDTO =new BankAccountResposeDTO();
   BeanUtils.copyProperties(bankAccount,bankAccountResposeDTO);
      return bankAccountResposeDTO;
    }
}
