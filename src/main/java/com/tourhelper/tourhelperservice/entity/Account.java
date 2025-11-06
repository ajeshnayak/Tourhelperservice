package com.tourhelper.tourhelperservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Account")
@Data
public class Account {
    @Id
    String userGuid;
    String emailId;
    String userName;
    String password;
    String userStatus;
    List<String> groupGuids;
}
