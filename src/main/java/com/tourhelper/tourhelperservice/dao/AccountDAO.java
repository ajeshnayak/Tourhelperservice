package com.tourhelper.tourhelperservice.dao;

import com.tourhelper.tourhelperservice.dto.AccountDto;
import com.tourhelper.tourhelperservice.entity.UserAccount;
import com.tourhelper.tourhelperservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Component
public class AccountDAO {

    @Autowired
    AccountRepository accountRepository;

    public AccountDto createAccount(AccountDto accountDto){
        UserAccount account= new UserAccount();
        account.setPassword(accountDto.getPassword());
        account.setEmailId(accountDto.getEmailId());
        account.setUserGuid(accountDto.getUserGuid());
        account.setUserName(accountDto.getUserName());
        account.setUserId(accountDto.getUserId());
        account.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        account.setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
        accountRepository.save(account);
        return accountDto;
    }

    public void deleteAccount(AccountDto accountDto){
        accountRepository.deleteById(accountDto.getUserGuid());
    }

    public boolean isAccountPresent(AccountDto accountDto) {
        Optional<UserAccount> account= Optional.ofNullable(accountRepository.findByEmailId(accountDto.getEmailId()));
        return account.isPresent();
    }

    public boolean isAccountPresentByGUID(AccountDto accountDto) {
        Optional<UserAccount> account= accountRepository.findById(accountDto.getUserGuid());
        return account.isPresent();
    }

    public int getLastUserId(){
        UserAccount userAccount= accountRepository.getLastUserId();
        if(userAccount == null){
            return 100000;
        }
        return userAccount.getUserId();
    }

}
