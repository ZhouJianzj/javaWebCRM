package com.zj.settings.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhoujian
 */
public class SqlSessionUtil {
    private static SqlSessionFactory  sqlSessionFactory;
    private static InputStream in;
    static {
        String config  = "Mybatis.xml";
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }
    public static SqlSession getSqlSession(){
        if (sqlSessionFactory != null) {
            return sqlSessionFactory.openSession();
        }
        return null;
    }
}
