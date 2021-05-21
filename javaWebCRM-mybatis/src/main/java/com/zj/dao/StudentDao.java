package com.zj.dao;

import com.zj.entities.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> select();

    /**
     *
     * @param student 发现没有的时候也可以实现，但是需要指定parameterType
     * @return
     */
    int insert(Student student);
    int update(Student student);
    int delete(int id);

    List<Student> selectOne();
    List<Student> selectTwo();

    List<Map<String, Object>> selectThree();
    List<Map<String, Object>> selectFour();
    List<Student> selectFive(List id);
    List<Student> selectSix(@Param("userName") String userName);

}
