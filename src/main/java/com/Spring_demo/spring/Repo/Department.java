package com.Spring_demo.spring.Repo;

public class Department {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    Integer id;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }

    String dept_name;


}
