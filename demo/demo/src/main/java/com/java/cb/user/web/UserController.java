package com.java.cb.user.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.cb.comment.service.CommentService;
import com.java.cb.comment.vo.Comment;
import com.java.cb.user.service.UserService;
import com.java.cb.user.vo.User;

@Controller
public class UserController {

	public UserController() {}

	private UserService userService;
	

	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
		
	}

	@RequestMapping(value="/",method=RequestMethod.GET)		//조회
	public String userHello(Model model,User user) {
		model.addAttribute("result",userService.selectUserList(user));
		return "main";
	}

	//등록화면페이지이동
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write() {
		return "write";
	}

	//등록
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String boardWriter(@ModelAttribute @Valid User user,  Errors errors) throws Exception {
		
		
		
		if(errors.hasErrors()) {
			List<ObjectError> list = errors.getAllErrors();
			for( ObjectError error : list ) {
				System.out.println(error.getDefaultMessage());
			}
			return "redirect:/write";
		}

		userService.writerBoard(user);
		return "redirect:/";
	}

	@RequestMapping(value="{id}/view",method= {RequestMethod.GET})		
	public String viewBoard(Model model, User user) {
		
		User userVO= userService.commentList(user);
		
		model.addAttribute("result",userService.viewBoard(user));
		model.addAttribute("commentList",userVO);
		
		return "view";
	}


	@RequestMapping(value="{id}/delete.do", method=RequestMethod.GET)
	public String boardDelete(User user) {
		userService.boardDelete(user);
		return "redirect:/";
	}

	@RequestMapping(value="{id}/update",method=RequestMethod.GET)
	public String update(Model model,User user) {
		model.addAttribute("result",userService.viewBoard(user));
		return "update";
	}
	@RequestMapping(value="{id}/update.do", method=RequestMethod.POST)
	public String boardUpdate(@ModelAttribute @Valid User user,  BindingResult bindingResult) throws Exception {

		if(bindingResult.hasErrors()) {
			List<ObjectError> list = bindingResult.getAllErrors();
			for( ObjectError error : list ) {
				System.out.println(error.getDefaultMessage());
			}
			return "redirect:/{id}/update";
			}

		userService.boardUpdate(user);
		return "redirect:/{id}/view";
	}
	
	
}
