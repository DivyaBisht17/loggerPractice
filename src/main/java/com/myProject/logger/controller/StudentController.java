package com.myProject.logger.controller;

import com.myProject.logger.model.Student;
import com.myProject.logger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/db")
@RestController

public class StudentController {
    @Autowired
    private StudentService stdService;
    @GetMapping("/getAll")
    public List<Student> getAll(){

        return stdService.getAll();
    }
    @PostMapping("/save")
    public Student addStudent(@RequestBody Student std){
        return stdService.addStudent(std);
    }
    @PutMapping("/edit")
    public Student updateStudent(@RequestBody Student std){

        return stdService.updateStudent(std);
    }

    @GetMapping("/get/{id}")
    public Student getById(@PathVariable Long id) {
        return stdService.getbyId(id);
    }

}
