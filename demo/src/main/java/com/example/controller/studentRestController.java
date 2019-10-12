package com.example.controller;
import com.example.Dao.StudentService;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "api/student")

public class studentRestController {
    @Resource
    StudentService studentService1;
    @RequestMapping("/hello")
    public String say(){
        return "{'message1': 'SpringBoot你大爷','message2','SpringBoot你大爷2'}";
    }
    @PostMapping(value = "/addStudent")
    public void addStudent(Student student){
        System.out.println("开始新增");
        studentService1.add(new Student(1,"嘻嘻",8000D));
        studentService1.add(new Student(2,"蛤蛤",9000D));
        studentService1.add(new Student(3,"666",10000D));
        studentService1.add(new Student(4,"111",11000D));
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public  void updateStudent(Student student){
        System.out.println("开始更新");
        studentService1.update(student);
    }

    @RequestMapping(value = "/studentId",method = RequestMethod.GET)
    public  Student findByStudentId(@RequestParam(value = "studentId",required = true)int studentId) throws Exception {
        System.out.println("开始查询");
        Student student=studentService1.findById(studentId);
        System.out.println(student.getId()+"--"+student.getName()+"--"+student.getSal());
        return student;
    }

}
