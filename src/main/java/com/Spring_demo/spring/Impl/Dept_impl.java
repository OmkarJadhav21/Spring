package com.Spring_demo.spring.Impl;

import com.Spring_demo.spring.Repo.Department;
import com.Spring_demo.spring.interfaced.Dept_Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Dept_impl implements Dept_Inter {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Department dept) {

    String sql="insert into Department values(?,?)";

    jdbcTemplate.update(sql,new Object[]{
            dept.getId(),dept.getDept_name()
    });



    }
}
