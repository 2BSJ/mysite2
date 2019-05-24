package com.cafe24.mysite.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private DataSource dataSource;

	
	public int delete(Long no,String password) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("no",no);
		map.put("password",password);
		return sqlSession.delete("guestbook.delete",map);
		
	}
	
	public int insert(GuestbookVo vo) {

		return sqlSession.insert("guestbook.insert",vo);
	}	
	
	public List<GuestbookVo> getList(){
		List<GuestbookVo> result = sqlSession.selectList("guestbook.getList");
		return result;
	}	
	
	public GuestbookVo getList(Long inputNo){
		GuestbookVo result = new GuestbookVo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select no, name, contents, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook where no=?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, inputNo);
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String contents = rs.getString(3);
				String regDate = rs.getString(4);
				
				
				result.setNo(no);
				result.setName(name);
				result.setContents(contents);
				result.setRegDate(regDate);
				
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
	public int modify(GuestbookVo vo){
	
		return sqlSession.insert("guestbook.modify",vo);
		
	}
}