package com.tourhelper.tourhelperservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;


@Entity
@Table(name="group_data")
@Data
public class Group {
    @Id
    @Column(name = "group_guid")
    String groupGuid;

    @Column(name = "status")
    String status;

    @Column(name = "group_name")
    String groupName;

    @Column(name = "owner")
    String owner;

    @Column(name = "created")
    Date created;
}
