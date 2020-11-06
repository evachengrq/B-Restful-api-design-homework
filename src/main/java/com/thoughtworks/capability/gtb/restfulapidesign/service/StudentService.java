package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(0, new Student(1, "Eva", "Female", "Eva studies Environmental Science."));
        studentList.add(1, new Student(2, "Roy", "Male", "Roy studies Civil Engineering."));
    }

    public List<Student> getStudent(String gender) {
        return studentList.stream().filter(student -> gender == null || student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        studentList.add(studentList.size(), student);
    }

    public void deleteStudent(Integer id) {
        studentList.remove(id - 1);
    }
}
