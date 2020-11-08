package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
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
        studentList.add(2, new Student(3, "Sylvia", "Female", "Sylvia studies Human Resources."));
        studentList.add(3, new Student(4, "Jacky", "Male", "Jacky studies Environmental Engineering."));
        studentList.add(4, new Student(5, "Khadija", "Female", "Khadija studies Environmental Science."));
        studentList.add(5, new Student(6, "Saniya", "Female", "Saniya studies Environmental Science."));
        studentList.add(6, new Student(7, "Louis", "Male", "Louis studies Environmental Science."));
        studentList.add(7, new Student(8, "Nirv", "Male", "Nirv studies Environmental Science."));
    }

    public List<Student> getAllStudent() { return studentList; }

    public Student getStudentById(int id) {
        return studentList.get(id - 1);
    }

    public List<Student> getStudentByGender(String gender) {
        return studentList.stream().filter(student -> gender == null || student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        studentList.add(studentList.size(), student);
    }

    public void deleteStudent(Integer id) {
        studentList.remove(id - 1);
    }


    public void updateStudent(int id, Student student) {
        student.setId(id);
        studentList.set(id - 1, student);
    }
}
