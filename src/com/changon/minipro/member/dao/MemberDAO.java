package com.changon.minipro.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.changon.minipro.common.DAO;
import com.changon.minipro.common.Dbinterface;
import com.changon.minipro.member.service.MemberVO;

public class MemberDAO extends DAO implements Dbinterface<MemberVO> {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String MEMBERLOGIN = "SELECT * FROM MEMBER WHERE MID = ? AND MPASSWORD = ?";

	@Override
	public ArrayList<MemberVO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO select(MemberVO vo) { // 지금은 로그인에서 사용한다.
		// 로그인 확인
		
		try {
			psmt = conn.prepareStatement(MEMBERLOGIN);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmAuth(rs.getString("mauth"));
				vo.setmName(rs.getString("mname"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
