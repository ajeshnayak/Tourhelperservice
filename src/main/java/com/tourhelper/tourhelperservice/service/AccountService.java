package com.tourhelper.tourhelperservice.service;

import com.tourhelper.tourhelperservice.dao.AccountDAO;
import com.tourhelper.tourhelperservice.dto.AccountDto;
import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.exception.AccountAlreadyExistException;
import com.tourhelper.tourhelperservice.exception.AccountDoesnotExistException;
import com.tourhelper.tourhelperservice.helper.AccountHelper;
import com.tourhelper.tourhelperservice.helper.UserIdSync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    AccountHelper accountHelper;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    UserIdSync userIdSync;

    public AccountDto createAccount(AccountDto accountDto) throws AccountAlreadyExistException {
        accountHelper.validateCreateAccount(accountDto);
        if(accountDAO.isAccountPresent(accountDto)){
            throw new AccountAlreadyExistException("ACCOUNT_ALREADY_PRESEENT");
        }
        encryptPassword(accountDto);
        accountDto.setUserGuid(UUID.randomUUID().toString());
        accountDto.setUserId(userIdSync.increment());
        accountDAO.createAccount(accountDto);
        return accountDto;
    }

    /**
     * use encryption for password encryption
     */
    private void encryptPassword(AccountDto accountDto) {
        Base64.Encoder encoder = Base64.getEncoder();

        // Encode the string to a byte array
        byte[] encodedBytes = encoder.encode(accountDto.getPassword().getBytes());

        // Convert the encoded byte array back to a string
        String encodedString = new String(encodedBytes);
        accountDto.setPassword(encodedString);

    }

    public AccountDto deleteAccount(AccountDto accountDto) throws AccountDoesnotExistException {
        accountHelper.validateDeleteAccount(accountDto);
        if(!accountDAO.isAccountPresentByGUID(accountDto)){
            throw new AccountDoesnotExistException("ACCOUNT_DOES_NOT_EXIST");
        }
        accountDAO.deleteAccount(accountDto);
        return accountDto;
    }

    public void addGrouptoOwner(GroupDto groupDto) {
       // accountDAO.addGrouptoAccount(groupDto,groupDto.getOwner());
    }


    public void addGrouptoUser(GroupDto groupDto) {
       // groupDto.getMembers().forEach(
          //      g->accountDAO.addGrouptoAccount(groupDto,g));
    }
}
