package com.java.cb.comment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.cb.comment.dao.CommentDAO;
import com.java.cb.comment.vo.Comment;
import com.java.cb.user.dao.UserDAO;
import com.java.cb.user.vo.User;


@Service
public class CommentService {

	public CommentService() {}
	
	private CommentDAO comDAO;
	private UserDAO userDAO;
	
	@Autowired
	public CommentService(CommentDAO comDAO) {
		this.comDAO=comDAO;
	}
	public List<Comment> selectCommentList(Comment com) {
		return comDAO.selectCommentList(com);
	}
	public void commentInsert(Comment com) {
		comDAO.commentInsert(com);
	}
	public void commentDelete(Comment com) {
		comDAO.commentDelete(com);
	}
	public void commentUpdate(Comment com) {
		comDAO.commentUpdate(com);
	}
	
}
