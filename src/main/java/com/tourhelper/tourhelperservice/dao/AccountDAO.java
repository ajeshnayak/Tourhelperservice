package com.tourhelper.tourhelperservice.dao;

import com.tourhelper.tourhelperservice.dto.AccountDto;
import com.tourhelper.tourhelperservice.entity.Account;
import com.tourhelper.tourhelperservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.tourhelper.tourhelperservice.constant.CommonConstants.ACTIVE;

@Component
public class AccountDAO {

    @Autowired
    AccountRepository accountRepository;

    public AccountDto createAccount(AccountDto accountDto){
        Account account= new Account();
        account.setPassword(accountDto.getPassword());
        account.setEmailId(accountDto.getEmailId());
        account.setUserGuid(accountDto.getUserGuid());
        account.setUserStatus(ACTIVE);
        account.setUserName(accountDto.getUserName());
        accountRepository.save(account);
        return accountDto;
    }

    public boolean isAccountPresent(AccountDto accountDto) {
        Optional<Account> account= Optional.ofNullable(accountRepository.findByEmailId(accountDto.getEmailId()));
        return account.isPresent();
    }
}
