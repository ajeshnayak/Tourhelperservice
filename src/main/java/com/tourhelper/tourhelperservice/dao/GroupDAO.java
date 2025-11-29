package com.tourhelper.tourhelperservice.dao;

import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.entity.Group;
import com.tourhelper.tourhelperservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.tourhelper.tourhelperservice.constant.CommonConstants.ACTIVE;


@Component
public class GroupDAO {
    @Autowired
    GroupRepository groupRepository;

    public Group createGroup(GroupDto groupDto){
        Group group= new Group();
        group.setGroupGuid(groupDto.getGroupGuid());
        group.setGroupName(groupDto.getGroupName());
        group.setOwner(groupDto.getOwner());
        group.setStatus(ACTIVE);
        return groupRepository.save(group);
    }

    public boolean isGroupPresent(GroupDto groupDto){
        List<Group> groupList=groupRepository.findByOwner(groupDto.getOwner());

        return groupList.stream()
                .anyMatch(group -> group.getGroupName()
                        .equalsIgnoreCase(groupDto.getGroupName()));
    }

    public boolean isGroupPresentbyGroupId(GroupDto groupDto) {
        List<Group> groupList= groupRepository.findByGroupGuid(groupDto.getGroupGuid());

        return groupList.stream()
                .anyMatch(group -> group.getGroupName()
                        .equalsIgnoreCase(groupDto.getGroupName()));
    }
}
