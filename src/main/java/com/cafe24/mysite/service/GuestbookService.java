package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getList(){
		
		return guestbookDao.getList();
	}
	
	public GuestbookVo getList(Long no) {
		return guestbookDao.getList(no);
	}
	
	public void modify(GuestbookVo vo) {
		guestbookDao.modify(vo);
		return ;
	}
	
	public void delete(Long no,String password) {
		guestbookDao.delete(no,password);
	}
	
	public void add(GuestbookVo vo) {
		guestbookDao.insert(vo);
	}
}
