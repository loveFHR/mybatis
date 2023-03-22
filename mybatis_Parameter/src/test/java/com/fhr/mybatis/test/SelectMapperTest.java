package com.fhr.mybatis.test;

import com.fhr.mybatis.mapper.SelectMapper;
import com.fhr.mybatis.pojo.User;
import com.fhr.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(6);
        System.out.println(user);

    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(3);
        System.out.println(map);
    }

    @Test
    public void testGetAllToMap(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> list = mapper.getAllUserToMap();
        System.out.println(list);
    }
    @Test
    public void testGetAllToMap2(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap2();
        System.out.println(map);
    }
}
