package com.linshili.service;

import com.linshili.mapper.UserMapper;
import com.linshili.pojo.User;
import com.linshili.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 登录
     */
    public User login(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.SelectByUsPa(username, password);
        sqlSession.close();
        return user;
    }
    /**
    注册
     */
    public Boolean register(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u= mapper.SelectUsername(user);
        if (u==null){
            //注册成功
           mapper.InsertUser(user);
           sqlSession.commit();
        }
       sqlSession.close();
        return u==null;
    }
}
