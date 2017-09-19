package com.Spring_demo.spring.interfaced;

import com.Spring_demo.spring.Student.Student;

import java.util.List;

public interface Inter {
    Student getdata();

    Integer add(Integer a ,Integer b);

    List<Student> selectQry();

    void saveToDB(Student st);


}
