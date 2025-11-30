package com.tourhelper.tourhelperservice.helper;

import com.tourhelper.tourhelperservice.dao.AccountDAO;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserIdSync {
    @Autowired
    AccountDAO accountDAO;

    private Integer userId;
    public synchronized Integer increment() {
        if(userId == null){
            userId = accountDAO.getLastUserId();
            userId ++;
        } else
            userId++;
        return userId;
    }

}
