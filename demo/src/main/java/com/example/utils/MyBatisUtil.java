package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

public class MyBatisUtil {
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    private  static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static  SqlSession getSqlSession(){
        SqlSession sqlSession=threadLocal.get();
        if(sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    public static  void closeSession(){
        SqlSession sqlSession=threadLocal.get();
        if(sqlSession!=null){
            sqlSession.close();
            threadLocal.remove();
        }
    }


    public static void main(String[] args) {
        Connection conn=MyBatisUtil.getSqlSession().getConnection();
        System.out.println(conn!=null?"连接成功":"连接失败");
    }
}
