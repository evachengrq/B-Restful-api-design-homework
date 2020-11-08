package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {

    private final int totalNumberOfGroups = 6;
    private List<Group> groupList = new ArrayList<>();
    private StudentService studentService;

    public GroupService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Group> groupStudents() {
        List<Student> studentList = studentService.getAllStudent();
        Collections.shuffle(studentList);

        for(int i = 0; i < totalNumberOfGroups; i++) {
            List<Student> groupedStudents = new ArrayList<>();
            groupedStudents.add(studentList.get(i));
            groupList.add(new Group(i+1, "Group" + (i+1), "the best group", groupedStudents));
        }
        for (int i = totalNumberOfGroups; i < studentList.size(); i++) {
            int groupIndex = i % totalNumberOfGroups;
            groupList.get(groupIndex).getStudentList().add(studentList.get(i));
        }
        return groupList;
    }


    public void updateGroupName(int id, String name) {
        groupList.get(id - 1).setName(name);
    }

    public List<Group> getAllGroups() {
        return groupList;
    }
}
