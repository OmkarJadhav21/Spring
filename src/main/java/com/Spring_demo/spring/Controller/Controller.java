package com.Spring_demo.spring.Controller;

import com.Spring_demo.spring.Impl.Implementation;
import com.Spring_demo.spring.Student.Student;
import com.Spring_demo.spring.interfaced.Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    public void setMyimpl(Implementation myimpl) {
        this.myimpl = myimpl;
    }
    @Autowired
    private Implementation myimpl;  //create setter for Implementation it will create setMyimpl method ^^^

    @GetMapping(value = "/getdata")
    Student data(){
        Student st=myimpl.getdata();
        System.out.println(st);
        return st;
    }

    @GetMapping(value = "/add/{a}/{b}")
    Integer add(@PathVariable Integer a,@PathVariable Integer b){
        return a+b;
    }




}
