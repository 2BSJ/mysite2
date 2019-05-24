package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(BoardVo vo) {

		return sqlSession.insert("board.insert",vo);
	}
	
	public List<BoardVo> getList(){
		List<BoardVo> result = sqlSession.selectList("board.getlist");
		return result;
	}
	
	public BoardVo getContents(Long no) {
		return sqlSession.selectOne("board.getcontents",no);
	}
	
	public int increaseHit(Long no) {
		return sqlSession.update("board.increaseHit",no);
	}
	
	public int modify(BoardVo vo) {
		
		int a=sqlSession.selectOne("board.checkreply",vo.getGroupNo());
		System.out.println(a);
		return sqlSession.update("board.modify",vo);
	}
	
	public int delete(Long no) {
		return sqlSession.delete("board.delete",no);
	}
	
	public int replyInsert(BoardVo vo){
		return sqlSession.insert("board.replyinsert",vo);
	}
	public int increaseOrderNo(BoardVo vo){
		return sqlSession.update("board.increaseorderno",vo);
	}
}
