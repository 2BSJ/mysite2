package com.cafe24.mysite.vo;

public class BoardVo {
	private Long no;
	private String writer;
	private String password;
	private String title;
	private String content;
	private String writeDate;
	
	
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", writer=" + writer + ", password=" + password + ", title=" + title + ", content="
				+ content + ", writeDate=" + writeDate + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
