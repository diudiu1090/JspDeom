package com.linshili.mapper;

import com.linshili.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //登录账号
   User SelectByUsPa(@Param("username") String username, @Param("password")String password);
   // User SelectByUsPa(User user);
    //用于查询用户是否存在
    @Select("select *from jd_user where username= #{username}")
    User SelectUsername(User user);

    //用于添加用户信息
    @Insert("insert into jd_user values(null,#{username},#{password})")
   void InsertUser(User user);


}
