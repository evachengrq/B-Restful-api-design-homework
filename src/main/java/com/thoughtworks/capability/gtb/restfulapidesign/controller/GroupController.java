package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @GetMapping("/groups")
    public List<Group> groupStudents() {
        return groupService.groupStudents();
    }

    @PutMapping("/groups/{id}")
    public void updateGroupNameById(@PathVariable int id, @RequestBody String name) {
        groupService.groupStudents();
        groupService.updateGroupName(id, name);
        System.out.println(groupService.getAllGroups());
    }

}
