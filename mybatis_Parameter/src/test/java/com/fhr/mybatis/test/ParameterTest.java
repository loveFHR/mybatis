package com.fhr.mybatis.test;

import com.fhr.mybatis.mapper.UserMapper;
import com.fhr.mybatis.pojo.User;
import com.fhr.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ParameterTest {
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("zhangsan");
        System.out.println(user);

    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("zhangsan" ,"zhangsan");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password","zhangsan");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "mary", "mary", 14, "女", "mary@123.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("zhangsan" ,"zhangsan");
        System.out.println(user);
    }
}
