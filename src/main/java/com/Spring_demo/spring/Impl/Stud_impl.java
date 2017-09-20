package com.Spring_demo.spring.Impl;

import com.Spring_demo.spring.Repo.Student;
import com.Spring_demo.spring.interfaced.Stud_Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Stud_impl implements Stud_Inter {

    @Autowired
    JdbcTemplate jdbcTemplate;


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

    @Override
    public List<Student> selectQry() {
        String sql="select * from mytab";
        List<Student>li=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return li;
    }

    @Override
    public void saveToDB(Student st) {
        String sql="insert into mytab values(?,?,?,?)";
       jdbcTemplate.update(sql,new Object[]{
            st.getId(),st.getName(),st.getCity(),st.getPath()
       });
    }

}