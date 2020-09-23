package com.java.cb.user.vo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.java.cb.comment.vo.Comment;
import java.util.Date;

public class User {

	@NotNull
	private int id;
	
	@NotNull
	@Size(min=1, max=25)
	private String title;
	
	@NotNull
	@Size(min=1, max=10)
	private String writer;
	
	@NotNull
	@Size(min=1, max=500)
	private String content;
	
	public Date board_date;
	
	private int idx;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Date getDate() {
		return board_date;
	}
	public void setDate(Date board_date) {
		this.board_date = board_date;
	}
	
	public List<Comment> commentList;

	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
}