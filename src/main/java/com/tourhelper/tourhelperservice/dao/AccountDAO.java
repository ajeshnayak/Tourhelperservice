package com.tourhelper.tourhelperservice.dao;

import com.tourhelper.tourhelperservice.dto.AccountDto;
import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.entity.Account;
import com.tourhelper.tourhelperservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    public void deleteAccount(AccountDto accountDto){
        accountRepository.deleteById(accountDto.getUserGuid());
    }

    public boolean isAccountPresent(AccountDto accountDto) {
        Optional<Account> account= Optional.ofNullable(accountRepository.findByEmailId(accountDto.getEmailId()));
        return account.isPresent();
    }

    public boolean isAccountPresentByGUID(AccountDto accountDto) {
        Optional<Account> account= accountRepository.findById(accountDto.getUserGuid());
        return account.isPresent();
    }

    public void addGrouptoAccount(GroupDto groupDto) {
        Optional<Account> account=accountRepository.findById(groupDto.getOwner());
        account.ifPresent(value -> {
            List<String> groupIds = Optional.ofNullable(value.getGroupGuids())
                    .orElseGet(() -> {
                        List<String> newList = new ArrayList<>();
                        value.setGroupGuids(newList);
                        return newList;
                    });
            groupIds.add(groupDto.getGroupId());
            value.setGroupGuids(groupIds);
            accountRepository.save(value);
        });

    }
}
