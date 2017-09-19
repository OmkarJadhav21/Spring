package com.Spring_demo.spring.Controller;

import com.Spring_demo.spring.Impl.Implementation;
import com.Spring_demo.spring.Student.Student;
import com.Spring_demo.spring.interfaced.Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    public void setMyimpl(Implementation myimpl) {
        this.myimpl = myimpl;
    }

    @Autowired
    private Implementation myimpl;  //create setter for (Implementation) it will create (setMyimpl method )^^^

    @GetMapping(value = "/getdata")
    Student data() {
        Student st = myimpl.getdata();
        System.out.println(st);
        return st;
    }

//    @GetMapping(value = "/add/{a}/{b}")
//    Integer add(@PathVariable Integer a,@PathVariable Integer b){
//        return a+b;
//    }

    @GetMapping(value = "/addition/{a}/{b}")
    public ResponseEntity<?> add(@PathVariable Integer a, @PathVariable Integer b) {
        Integer data = myimpl.add(a, b);
        Map<String, Object> map = new HashMap<>();
        map.put("Value is ", data);
        ResponseEntity<?> entity = new ResponseEntity(map, HttpStatus.OK);
        return entity;

    }

   @GetMapping(value = "/select")
   Map<String,Object> selectQry() {
       List<Student> l = myimpl.selectQry();
       Map<String, Object> map = new HashMap<>();
       map.put("status", "success");
       map.put("result", l);
       return map;
   }

   @PostMapping(value = "/saveToDatabase")
    String savedata(@RequestParam Integer id,
                    @RequestParam String name,
                    @RequestParam String city){

        Student s=new Student();
           s.setId(id);
           s.setName(name);
           s.setCity(city);
        myimpl.saveToDB(s);
        return "Data Saved Successfully";
   }
}
