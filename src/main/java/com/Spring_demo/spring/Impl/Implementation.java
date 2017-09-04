package com.Spring_demo.spring.Impl;

import com.Spring_demo.spring.Student.Student;
import com.Spring_demo.spring.interfaced.Inter;
import org.springframework.stereotype.Service;

@Service
public class Implementation implements Inter {
@Override
    public Student getdata() {
        Student st=new Student();
        st.setId(1);
        st.setName("Omkar");
        st.setCity("Pune");
        return st;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        Integer c=a+b;
        return c;

    }
}