package com.example.Dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    Student findById(int id)throws Exception;
    List<Student> findAll()throws Exception;
    void update(Student student);
    void delete(Student student);
    Student findByIdMap(int id)throws Exception;
    List<Student> findAllByNameWithFy(String name,int start,int size)throws Exception;

}
