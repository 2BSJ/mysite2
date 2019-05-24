package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public int insert(BoardVo vo) {
		if(vo.getOrderNo()==0) {
			return boardDao.insert(vo);
		}
		else {	
		boardDao.increaseOrderNo(vo);
		return boardDao.replyInsert(vo);
		}
	}
	
	public List<BoardVo> getList(){
		return boardDao.getList();
	}
	
	public BoardVo getContents(Long no) {
		boardDao.increaseHit(no);
		return boardDao.getContents(no);
	}
	
	public int modify(BoardVo vo) {
		return boardDao.modify(vo);
	}
	
	public int delete(Long no) {
		return boardDao.delete(no);
	}
}
