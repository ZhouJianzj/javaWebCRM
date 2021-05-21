package com.zj;

import static org.junit.Assert.assertTrue;

import com.zj.dao.StudentDao;
import com.zj.entities.Student;
import com.zj.utils.sqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest<pubilc>
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void select() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.zj.dao.StudentDao.select";
        List<Student> objects = sqlSession.selectList(sqlId);
//        objects.forEach(i-> System.out.println(i.getName()));
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void insert() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.zj.dao.StudentDao.insert";
        int insert = sqlSession.insert(sqlId,new Student(3,"彰化",34));
        sqlSession.commit();
        System.out.println(insert);
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void update() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.zj.dao.StudentDao.update";
        int 侯蔡 = sqlSession.update(sqlId, new Student(1, "侯蔡", 24));
        sqlSession.commit();
        System.out.println(侯蔡);
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void delete() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.zj.dao.StudentDao.delete";
        int delete = sqlSession.delete(sqlId, 3);
        sqlSession.commit();
        System.out.println(delete);
    }
    @Test
    public void utils(){
//        自己封装的类
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        List<Object> objects = sqlSession.selectList("com.zj.dao.StudentDao.select");
        objects.forEach(i-> System.out.println(i));
    }
    /**
     * 测试的是使用的resultMap
     */
    @Test
    public void testResultMap(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        StudentDao studentDaoImpl = sqlSession.getMapper(StudentDao.class);
        List<Student> students = studentDaoImpl.selectOne();
        for(Student stu : students){
            System.out.println(stu);
        }
    }
    /**
     * 测试的是使用As代替resultMap
     */
    @Test
    public void testAs(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        StudentDao studentDaoImpl = sqlSession.getMapper(StudentDao.class);
        List<Student> students = studentDaoImpl.selectTwo();
        for(Student stu : students){
            System.out.println(stu);
        }
    }

    /**
     * 测试的是返回的是map
     */
    @Test
    public void testMap(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        StudentDao studentDaoImpl = sqlSession.getMapper(StudentDao.class);
        List<Map<String, Object>> maps = studentDaoImpl.selectThree();
        for(Map<String, Object> map:maps){
            Set<String> strings = map.keySet();
            for (String str : strings){
                System.out.print(str + " ");
                System.out.println(map.get(str));
            }
        }
    }

    /**
     * 测试的是没有指定的实体类与之对应，返回为map
     */
    @Test
    public void testNOtFindEntityAsMap(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        StudentDao studentDaoImpl = sqlSession.getMapper(StudentDao.class);
        List<Map<String, Object>> maps = studentDaoImpl.selectFour();
        for(Map<String, Object> map:maps){
            Set<String> strings = map.keySet();
            for (String str : strings){
                System.out.print(str + " ");
                System.out.println(map.get(str));
            }
        }
    }

    /**
     * 测试的是使用foreach测试where in（）
     */
    @Test
    public void testIn(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        StudentDao studentDaoImpl = sqlSession.getMapper(StudentDao.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        List<Student> students = studentDaoImpl.selectFive(arrayList);
        for(Student student : students){
            System.out.println(student);
        }
    }
    @Test
    public void testLike(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        StudentDao studentDaoImpl = sqlSession.getMapper(StudentDao.class);
        List<Student> students = studentDaoImpl.selectSix("健");
        for (Student student : students){
            System.out.println(student);
        }
    }
}
