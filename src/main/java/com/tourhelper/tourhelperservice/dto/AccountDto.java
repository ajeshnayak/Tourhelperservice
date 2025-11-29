package com.tourhelper.tourhelperservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.List;

@Data
public class AccountDto {
    String userGuid;
    Integer userId;
    String emailId;
    String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    String userStatus;
    List<Integer> groupIds;
}
//data storage,
//account already exist check,
