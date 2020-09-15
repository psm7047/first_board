package com.java.cb.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.cb.comment.vo.Comment;

@Mapper
public interface CommentDAO {

	List<Comment> selectCommentList(Comment com);
	
	public void commentInsert(Comment com);
	public void commentDelete(Comment com);
	public void commentUpdate(Comment com);
	
}
