package com.newer.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.newer.domain.User;
import com.newer.service.UserService;
import com.newer.util.MyConstants;

@RestController
@RequestMapping("login")
//将名字为：MyConstants.SESSSION_USER的属性同时绑定到session中
@SessionAttributes(MyConstants.SESSSION_USER)
public class LoginController {
	@Autowired
	private UserService userService;
  
	 
	@RequestMapping("login")
	public User login(String name,String upwd,Model model,HttpSession session ) {
		User user=this.userService.login(name, upwd);
		if (user!=null) {
			model.addAttribute(MyConstants.SESSSION_USER, user);
		} 
	    return user;
	}
	
	 
	@RequestMapping("logout")
	public String  logout(HttpSession session,SessionStatus sessionStatus) {
		session.invalidate();
		sessionStatus.setComplete();
		return "redirect:/index.jsp";
	}
}
