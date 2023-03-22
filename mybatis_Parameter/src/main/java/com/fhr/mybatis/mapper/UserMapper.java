package com.fhr.mybatis.mapper;

import com.fhr.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.Map;


/**
 * mybatis获取参数的两种方式:#{}和${}
 * #{}的本质是占位符，${}的本质是字符串的拼接
 *
 * 1.若mapper接口方法的参数为单个字面量类型
 * 此时可以通过#{}和${}以任意的内容获取参数值，一定要注意${}的单引号问题
 *
 * 2.若mapper接口方法的参数为多个字面值类型
 * 此时mybatis 会将参数放入map集合中，以两种方式存储数据
 *  a.以arg0,arg1,...为键,以参数为值
 *  b.以param1,param2,...为键，以参数为值
 * 因此，只需要通过#{}和${}访问map集合的键，就可以获取相对应的值，一定要注意单引号的问题
 *
 * 3.若mapper接口方法的参数为一个map集合的参数
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对应的值，一定要注意单引号的问题
 *
 * 4.若mapper接口方法的参数是实体类类型的参数
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值，一定要注意单引号的问题
 *
 * 5.可以在mapper接口方法的参数前设置@param注解
 *  a.以@param注解的value为键，以参数为值
 *  b.以param1,param2,...为键，以参数为值
 *  只需要通过#{}和${}访问map集合的键，就可以获取相对应的值，一定要注意单引号的问题
 */
public interface UserMapper {
    /**
     *通过用户名查询用户信息
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 通过map集合验证登录
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录，使用@param注解
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
