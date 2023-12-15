package com.crud.board;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardVO vo = new BoardVO();
        vo.setSeq(rs.getInt("seq"));
        vo.setTag(rs.getString("tag"));
        vo.setWriter(rs.getString("writer"));
        vo.setContent(rs.getString("content"));
        vo.setBirthdate(rs.getString("birthdate"));
        vo.setCountry(rs.getString("country"));
        vo.setGender(rs.getString("gender"));
        vo.setRegdate(rs.getString("regdate"));
        return vo;
    }
}
