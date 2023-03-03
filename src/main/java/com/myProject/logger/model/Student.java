package com.myProject.logger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="student")
public class Student {
    @Id
    private Long id;
    private String name;
    private  String branch;
    private Long rollno;
    private String Email;
    private Long mobileno;
}
