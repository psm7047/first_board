package com.java.cb.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.cb.user.vo.User;

@Mapper
public interface UserDAO {
	
	List<User> selectUserList(User user);
	public void writerBoard(User user);
	public User viewBoard(User user);
	public void boardDelete(User user);
	public void boardUpdate(User user);
	
}
