package com.tourhelper.tourhelperservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupDto {
    String groupGuid;
    String groupName;
    String owner;
    String status;
    List<String> members;
}
