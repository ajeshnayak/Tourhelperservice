package com.tourhelper.tourhelperservice.service;

import com.tourhelper.tourhelperservice.dao.GroupDAO;
import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.exception.GroupAlreadyExistException;
import com.tourhelper.tourhelperservice.helper.GroupHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    @Autowired
    GroupHelper groupHelper;

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    AccountService accountService;

    public GroupDto createGroup(GroupDto groupDto) throws GroupAlreadyExistException {
        groupHelper.validateCreateGroupData(groupDto);
        groupDto.setGroupGuid(UUID.randomUUID().toString());
        if(groupDAO.isGroupPresent(groupDto)){
            throw new GroupAlreadyExistException("GROUP_ALREADY_EXIST");
        }
        groupDAO.createGroup(groupDto);
        accountService.addGrouptoOwner(groupDto);
        return groupDto;
    }

    public GroupDto addMember(GroupDto groupDto) throws GroupAlreadyExistException {
        groupHelper.validateAddMemberData(groupDto);
        if(!groupDAO.isGroupPresentbyGroupId(groupDto)){
            throw new GroupAlreadyExistException("GROUP_DOES_NOT_EXIST");
        }
        accountService.addGrouptoUser(groupDto);
      //  groupDAO.addUsertoGroup(groupDto);
        return groupDto;
    }
}
