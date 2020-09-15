package com.java.cb.comment.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.cb.comment.service.CommentService;
import com.java.cb.comment.vo.Comment;
import com.java.cb.user.service.UserService;
import com.java.cb.user.vo.User;

@Controller
public class CommentController {
	
	public CommentController() {}
	
	private CommentService comService;
	
	@Autowired
	public CommentController(CommentService comService) {
		this.comService=comService;
	}
	
	@RequestMapping(value="/comment", method=RequestMethod.GET)
	public String commentSelect( Model model, Comment com) {
		
		return "comment";
		
	}
	@GetMapping("/commentList")
	@ResponseBody
	public List<Comment> findCommentList(Comment com) {
		return comService.selectCommentList(com);
	}
	
	
	@PostMapping("/new")
	@ResponseBody
	public HashMap<String, Object> Insert(Comment com) {
		
		comService.commentInsert(com);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();	
		
		List<Comment> resultList=comService.selectCommentList(com);
		resultMap.put("resultList", resultList);
		resultMap.put("flag", "success");
					
			return resultMap;
			
	}
	
	@DeleteMapping("/{bno}")
	@ResponseBody
	public HashMap<String, Object> Delete(Comment com) {
		
		comService.commentDelete(com);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();	
		
		List<Comment> resultList=comService.selectCommentList(com);
		resultMap.put("resultList", resultList);
		resultMap.put("flag", "success");
					
			return resultMap;
			
	}
	
	@PostMapping("/update")
	@ResponseBody
	public HashMap<String, Object> Update(Comment com) {
		
		comService.commentUpdate(com);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();	
		
		List<Comment> resultList=comService.selectCommentList(com);
		resultMap.put("resultList", resultList);
		resultMap.put("flag", "success");
					
			return resultMap;
			
	}
	

}
