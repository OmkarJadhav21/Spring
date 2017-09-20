package com.Spring_demo.spring.Controller;

import com.Spring_demo.spring.Impl.Dept_impl;
import com.Spring_demo.spring.Impl.Stud_impl;
import com.Spring_demo.spring.Repo.Department;
import com.Spring_demo.spring.Repo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Stud_Controller {


    @Autowired
    public void setMyimpl(Stud_impl myimpl) {
        this.myimpl = myimpl;
    }

    @Autowired
    private Stud_impl myimpl;  //create setter for (Stud_impl) it will create (setMyimpl method )^^^

    public void setDept_impl(Dept_impl dept_impl) {
        this.dept_impl = dept_impl;
    }

    @Autowired
    private Dept_impl dept_impl;








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
//use GET method of postman
   }

   @PostMapping(value = "/saveToDatabase")
    String savedata(@RequestParam Integer id,
                    @RequestParam String name,
                    @RequestParam String city,
                    @RequestParam MultipartFile file){

        String imageName=file.getOriginalFilename();
        File f=new File("/Users/Techteam/Desktop/images/"+imageName);
        String st1=f.getAbsolutePath();
       System.out.println(st1);

        Student s=new Student();
           s.setId(id);
           s.setName(name);
           s.setCity(city);
           s.setPath(imageName);

       try {
           file.transferTo(f);
       } catch (IOException e) {
           e.printStackTrace();
       }

       myimpl.saveToDB(s);
        return "Data Saved Successfully";
//POST->form-data->type Key and value
   }

   @PostMapping(value = "/deptAndStudData")
    String getCombine(@RequestBody Student stud){
       Department d=new Department();
       d=stud.getDept();
       dept_impl.save(d);

       Student s1=new Student();
       s1.setId(stud.getId());
       s1.setName(stud.getName());
       s1.setCity(stud.getCity());
       s1.setPath(stud.getPath());
       s1.setDept(stud.getDept());
       myimpl.saveToDB(s1);
       return  "Data saved and combined";
//POST->raw JSON->{ "id:1","":"",..."dept":{"dept_name"}}
   }
}
