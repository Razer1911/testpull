package com.example.Dao;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface StudentService {
    void add(Student student);
    Student findById(int id)throws Exception;
    List<Student> findAll()throws Exception;
    void update(Student student);
    void delete(Student student);
    Student findByIdMap(int id)throws Exception;
    List<Student> findAllByNameWithFy(String name,int start,int size)throws Exception;

}
