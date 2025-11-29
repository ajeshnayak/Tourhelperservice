package com.tourhelper.tourhelperservice.helper;

import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.exception.InvalidArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class GroupHelper {

    public void validateCreateGroupData(GroupDto groupDto){
        if(StringUtils.isBlank(groupDto.getGroupName())){
            throw new InvalidArgumentException("EMPTY_GROUP_NAME");
        }
        if(StringUtils.isBlank(groupDto.getOwner())){
            throw new InvalidArgumentException("EMPTY_OWNER_DETAILS");
        }
    }

    public void validateAddMemberData(GroupDto groupDto) {
        if(groupDto.getMembers().isEmpty()){
            throw new InvalidArgumentException("EMPTY_MEMBER_LIST");
        }
        if(StringUtils.isBlank(groupDto.getGroupGuid())){
            throw new InvalidArgumentException("EMPTY_GROUP_ID");
        }
        if(StringUtils.isBlank(groupDto.getOwner())){
            throw new InvalidArgumentException("EMPTY_GROUP_OWNER");
        }
    }
}
