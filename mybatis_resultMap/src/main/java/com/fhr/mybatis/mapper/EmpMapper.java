package com.fhr.mybatis.mapper;

import com.fhr.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") Integer id);

    /**
     * 获取员工以及所对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptById(@Param("empId")Integer empId);
}
