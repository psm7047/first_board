package com.java.cb.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.cb.comment.service.CommentService;
import com.java.cb.comment.vo.Comment;
import com.java.cb.user.dao.UserDAO;
import com.java.cb.user.vo.User;

@Service
public class UserService {

	private UserDAO userDAO;
	private CommentService commentService;
	
	public UserService() {}

	@Autowired
	public UserService(UserDAO userDAO,
			           CommentService commentService) {
		this.userDAO=userDAO;
		this.commentService=commentService;
	}
	
	public List<User> selectUserList(User user) {
		return userDAO.selectUserList(user);
	}
	
	//comment
	public User commentList(User user) {
		
		User resultVo=new User();
		Comment Comment = new Comment();
		
		Comment.setBno(user.getId());
		resultVo.setCommentList(commentService.selectCommentList(Comment));
		
		return resultVo;
	}
	
	public void writerBoard(User user) {
		userDAO.writerBoard(user);
	}
	public User viewBoard(User user) {
		return userDAO.viewBoard(user);
	}
	public void boardDelete(User user) {
		 userDAO.boardDelete(user);
	}
	public void boardUpdate(User user) {
		 userDAO.boardUpdate(user);
	}
	
}
