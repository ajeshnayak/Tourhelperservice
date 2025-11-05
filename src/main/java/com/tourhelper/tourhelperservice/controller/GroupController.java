package com.tourhelper.tourhelperservice.controller;

import com.tourhelper.tourhelperservice.dto.GroupDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

    @PostMapping("/create")
    public GroupDto createGroup(@RequestBody GroupDto groupDto){
        return groupDto;
    }
}
