package com.Spring_demo.spring.interfaced;

import com.Spring_demo.spring.Repo.Student;

import java.util.List;

public interface Stud_Inter {
    Student getdata();

    Integer add(Integer a ,Integer b);

    List<Student> selectQry();

    void saveToDB(Student st);


}
