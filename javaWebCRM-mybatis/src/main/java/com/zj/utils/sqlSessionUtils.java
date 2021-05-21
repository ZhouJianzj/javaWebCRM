package com.zj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class sqlSessionUtils {
//    配置文件
    private static String config = "mybatis.xml";
//    获取的字节流
    private static InputStream inputStream = null;
//    sqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory = null;
//    就是一个伴随线程的数组，里面放的sqlSession 也就是sqlSessionFactory.openSession
    private static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    /**
     *通过获取配置文件的字节流创建sqlSessionFactory，
     */
    static {
        try {
          inputStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession(){
//        数组获取，数组中没有就使用openSession()创建
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if (sqlSession == null){
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            sqlSessionThreadLocal.set(sqlSession1);
            return sqlSession1;
        }
        return sqlSession;
    }
}
