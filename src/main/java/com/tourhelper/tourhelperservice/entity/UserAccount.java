package com.tourhelper.tourhelperservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "user_account")
@Data
public class UserAccount {

    @Column(name = "user_guid")
    @Id
    String userGuid;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "user_name")
    String userName;

    @Column(name = "password")
    String password;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "created")
    Date created;

    @Column(name = "last_updated")
    Timestamp lastUpdated;
}
