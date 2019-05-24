package com.cafe24.mysite.vo;

public class BoardVo {
	private Long no;
	private String title;
	private String contents;
	private int hit;
	private String regDate;
	private int groupNo;
	private int orderNo;
	private int depth;
	private Long userNo;
	private String name;
	


	public BoardVo() {
	}
	
//	public BoardVo(Long no,String title,String contents,int hit,String regDate, int groupNo,
//			       int orderNo,int depth,int userNo) {
//		
//			this.no=no;
//			this.title=title;
//			this.contents=contents;
//			this.hit=hit;
//			this.regDate=regDate;
//			this.groupNo=groupNo;
//			this.orderNo=orderNo;
//			this.depth=depth;
//			this.userNo=userNo;		
//	}
	
	public BoardVo(String title,String contents,Long userNo,int depth,int groupNo) {
	
		this.title=title;
		this.contents=contents;
		this.userNo=userNo;		
		this.depth= depth;
		this.groupNo= groupNo;
}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
