package com.example.Dao;

import com.example.entity.Student;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImp implements StudentService{

    @Override
    public void add(Student student) {
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtil.getSqlSession();
            sqlSession.insert(Student.class.getName()+".add",student);
            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public Student findById(int id) throws Exception{
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.getSqlSession();
            Student student=sqlSession.selectOne(Student.class.getName()+".findById",id);
            sqlSession.commit();
            return student;
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public List<Student> findAll() throws Exception{
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.getSqlSession();
            return sqlSession.selectList(Student.class.getName()+".findAll");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public void update(Student student) {
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.getSqlSession();
            sqlSession.update(Student.class.getName()+".update",student);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public void delete(Student student) {
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.getSqlSession();
            sqlSession.delete(Student.class.getName()+".delete",student);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public Student findByIdMap(int id) {
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.getSqlSession();
            Student student=sqlSession.selectOne(Student.class.getName()+".findById",id);
            sqlSession.commit();
            return student;
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public List<Student> findAllByNameWithFy(String name, int start, int size) {
        SqlSession sqlSession=null;
        try{
            sqlSession=MyBatisUtil.getSqlSession();
            Map<String,Object> map=new LinkedHashMap<String,Object>();
            map.put("pname","%"+name+"%");
            map.put("pstart",start);
            map.put("psize",size);
            return sqlSession.selectList(Student.class.getName()+"findAllByNameWithFy",map);

        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    public static void main(String[] args) throws Exception {
        StudentServiceImp dao=new StudentServiceImp();
//        dao.add(new Student(1,"嘻嘻",8000D));
//        dao.add(new Student(2,"蛤蛤",9000D));
//        dao.add(new Student(3,"666",10000D));
//        dao.add(new Student(4,"111",11000D));

        Student student = dao.findById(4);
        System.out.println(student.getId()+"--"+student.getName()+"--"+student.getSal());

    }

}
