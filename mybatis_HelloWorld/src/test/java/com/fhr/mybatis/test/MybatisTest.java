package com.fhr.mybatis.test;

import com.fhr.mybatis.mapper.UserMapper;
import com.fhr.mybatis.pojo.User;
import com.fhr.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testInsert(){

        try {
            //获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sql的会话对象SqlSession,是Mybatis提供的操作数据库的对象
            SqlSession sqlSession = sqlSessionFactory.openSession();//不会自动提交，自动提交加True
            //获取UserMapper的代理实现类接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用mapper接口中的方法，实现添加用户信息的功能
            //int result = sqlSession.insert("com.fhr.mybatis.mapper.UserMapper.insertUser");
            int result = userMapper.insertUser();
            System.out.println("结果" + result);
            //提交事务
            sqlSession.commit();
            //关闭资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
