package com.Spring_demo.spring.Repo;

public class Student {

    Integer id;
    String name;

    String city;
    String path;

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", path='" + path + '\'' +
                ", dept=" + dept +
                '}';
    }

    Department dept;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }







}
