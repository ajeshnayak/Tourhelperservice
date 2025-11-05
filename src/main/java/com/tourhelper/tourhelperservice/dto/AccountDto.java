package com.tourhelper.tourhelperservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    String userGuid;
    String emailId;
    String userName;
    String password;
    String userStatus;
    List<Integer> groupIds;
}
//data storage,
//account already exist check,
