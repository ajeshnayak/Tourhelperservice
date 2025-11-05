package com.tourhelper.tourhelperservice.service;

import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.helper.GroupHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupHelper groupHelper;

    public GroupDto createGroup(GroupDto groupDto){
        groupHelper.validateCreateGroupData(groupDto);
        return groupDto;
    }
}
