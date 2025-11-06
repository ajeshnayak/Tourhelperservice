package com.tourhelper.tourhelperservice.controller;

import com.tourhelper.tourhelperservice.dao.GroupDAO;
import com.tourhelper.tourhelperservice.dto.GroupDto;
import com.tourhelper.tourhelperservice.exception.GroupAlreadyExistException;
import com.tourhelper.tourhelperservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/create")
    public GroupDto createGroup(@RequestBody GroupDto groupDto) throws GroupAlreadyExistException {
        return groupService.createGroup(groupDto);
    }
}
