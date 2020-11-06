package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(0, new Student(1, "Eva", "Female", "Eva studies Environmental Science."));
        studentList.add(1, new Student(2, "Roy", "Male", "Roy studies Civil Engineering."));
    }

//    public List<Student> getStudent() {
//        return studentList;
//    }

    public void addStudent(Student student) {
        studentList.add(studentList.size(), student);
    }
}
