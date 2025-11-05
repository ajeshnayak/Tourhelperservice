package com.tourhelper.tourhelperservice.dao;

import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.entity.Group;
import com.tourhelper.tourhelperservice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GroupDAO {
    @Autowired
    GroupRepository groupRepository;

    public Group createGroup(GroupDto groupDto){
        Group group= new Group();
        group.setGroupId(groupDto.getGroupId());
        group.setGroupName(groupDto.getGroupName());
        group.setOwner(groupDto.getOwner());
        return groupRepository.save(group);
    }
}
