package com.crud.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserDAO {
    @Autowired
    SqlSessionTemplate sqlSession;

    public UserVO getUser(UserVO vo) {
        return sqlSession.selectOne("User.getUser", vo);
    }


}
