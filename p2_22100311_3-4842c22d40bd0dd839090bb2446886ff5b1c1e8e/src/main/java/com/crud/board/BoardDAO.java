package com.crud.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	@Autowired
	JdbcTemplate jdbcTemplate;

	class BoardRowMapper implements RowMapper<BoardVO> {
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
			vo.setRegdate(rs.getString("regdate")); // regdate 매핑 추가
			return vo;
		}
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertBoard(BoardVO vo) {

		String BOARD_INSERT = "insert into BOARD (tag, writer, content, birthdate, country, gender, regdate) values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(BOARD_INSERT, new Object[]{vo.getTag(), vo.getWriter(), vo.getContent(), vo.getBirthdate(), vo.getCountry(), vo.getGender(), vo.getRegdate()});
	}

	public int deleteBoard(int seq) {
		String BOARD_DELETE = "delete from BOARD  where seq=?";
		return jdbcTemplate.update(BOARD_DELETE, new Object[]{seq});
	}
	public int updateBoard(BoardVO vo){
		String sql = "update BOARD set tag = '" + vo.getTag() + "',"
				+ " writer='" + vo.getWriter() + "',"
				+ " content='" + vo.getContent() + "',"
				+ " birthdate='" + vo.getBirthdate() + "',"
				+ " country='" + vo.getCountry() + "',"
				+ " gender='" + vo.getGender() + "',"
				+ " regdate='" + vo.getRegdate() + "' where seq=" + vo.getSeq();
		return jdbcTemplate.update(sql);
	}

	public BoardVO getBoard(int seq){
		String BOARD_GET = "select * from BOARD  where seq=?";
		return jdbcTemplate.queryForObject(BOARD_GET, new Object[]{seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	public List<BoardVO> getBoardList(){
		String BOARD_LIST = "select * from BOARD order by seq desc";
		return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO data = new BoardVO();
				data.setSeq(rs.getInt("seq"));
				data.setTag(rs.getString("tag"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setBirthdate(rs.getString("birthdate"));
				data.setCountry(rs.getString("country"));
				data.setGender(rs.getString("gender"));
				data.setRegdate(rs.getString("regdate"));
				return data;
			}
		});
	}
}