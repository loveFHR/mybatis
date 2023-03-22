package com.fhr.mybatis.test;

import com.fhr.mybatis.mapper.SpecialSQLMapper;
import com.fhr.mybatis.pojo.User;
import com.fhr.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class SpecialSQLTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("10,11");
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null,"xiaoming","123",12,"男","xiaoming@123.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void testJDBC(){
        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("","","");
            String sql = "insert into t_user values()";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.executeQuery();
            ResultSet resultSet = ps.getGeneratedKeys();
            resultSet.next();
            resultSet.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
