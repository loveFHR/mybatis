package com.fhr.mybatis.test;

import com.fhr.mybatis.mapper.EmpMapper;
import com.fhr.mybatis.pojo.Emp;
import com.fhr.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {

    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);

    }

    @Test
    public void testGetEmpAndDeptById(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptById(1);
        System.out.println(emp);

    }
}
