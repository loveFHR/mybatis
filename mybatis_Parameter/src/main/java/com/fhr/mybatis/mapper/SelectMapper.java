package com.fhr.mybatis.mapper;

import com.fhr.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id")Integer id);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户数量
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个Map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * 查询所有用户到map集合
     * @return
     */

    List<Map<String, Object>> getAllUserToMap();

    /**
     * 查询所有用户到map集合
     * 若查询的结果有多条时，并且要将每条数据转换为map集合
     * 此时有两种解决方案：
     *  a.将mapper接口方法的返回值放入List集合中
     *  b.可以将每条数据转换的map放入一个大的map集合中，但必须通过@MapKey注解
     *  将查询的某个字段的值作为大的map的键
     * @return
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMap2();

}
