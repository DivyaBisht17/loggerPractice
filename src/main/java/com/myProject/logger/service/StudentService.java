package com.myProject.logger.service;

import com.myProject.logger.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();
    public Student addStudent(Student std);

    public Student updateStudent(Student std);

    public  Student getbyId(Long  id);

}
