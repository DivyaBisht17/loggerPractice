package com.myProject.logger.service;

import com.myProject.logger.model.Student;
import com.myProject.logger.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j   //This annotation use for logger

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository stdRepository;

    @Override
    public List<Student> getAll() {
        try {
            List<Student> std = stdRepository.findAll();
            if (std != null)
                log.info("get all api is working --->" + std);

        } catch (Exception e) {
            log.error("error:-->" + e.getMessage());
        }
        return stdRepository.findAll();
    }


    @Override
    public Student addStudent(Student std) {
        log.info("Student Service :  add student api  -->");
        Student result = null;
        result = stdRepository.save(std);
        try {
            result = stdRepository.save(std);
        } catch (Exception e) {
            log.error("std service:error=" + e.getMessage());
        }
        return result;
    }


    @Override
    public Student updateStudent(Student std) {
        log.info("std service:update -->");
        Student result = null;
        Student std1 = stdRepository.getById(std.getId());
        try {
            if (std.getName() != null)
                std1.setName(std.getName());
            if (std.getBranch() != null)
                std1.setBranch(std.getBranch());
            if (std.getRollno() != null)
                std1.setRollno(std.getRollno());
            if (std.getEmail() != null)
                std1.setEmail(std.getEmail());
            if (std.getMobileno() != null)
                std1.setMobileno(std.getMobileno());

            result = stdRepository.save(std1);
        } catch (Exception e) {
            log.error("Student serice :error=" + e.getMessage());

        }
        return result;
    }


    @Override
    public Student getbyId(Long id) {
        log.info("entered into getById---->>");
        try{
            Student student = stdRepository.findById(id).get();
            if(student.getId()!=null){
                log.info("the id is not empty");
            }
            else{
                log.warn("you have entered wrong !!!!");
            }
        }
        catch(Exception e){
            log.error("error---->"+e.getMessage());
        }
        return stdRepository.findById(id).get();
    }
}
