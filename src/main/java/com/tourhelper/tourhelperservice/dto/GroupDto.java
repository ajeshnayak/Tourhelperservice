package com.tourhelper.tourhelperservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupDto {
    String groupId;
    String groupName;
    String owner;
    List<String> members;
}
