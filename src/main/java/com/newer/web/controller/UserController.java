package com.newer.web.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.newer.domain.User;
import com.newer.dto.MsgDto;
import com.newer.dto.UserDto;
import com.newer.service.UserService;

//@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	 
	@RequestMapping("findPages")
	public PageInfo fingPages(UserDto userDto,ModelMap modelMap) {
		PageInfo pageInfo=this.userService.findPages(userDto);
		modelMap.addAttribute("pageInfo", pageInfo);
		return pageInfo;
	}
	
	/**
	 * 异步处理时，如果没有文件上传
	 * @param user
	 * @return
	 * @throws Exception
	 * save1(User user) 接收的参数是该格式提交的数据application/x-www-form-urlencoded
	 *  客户端以application/json格式提交数据时，必须使用注解@RequestBody
	 */
	@RequestMapping("save1")
	public MsgDto save1(@RequestBody User user) throws Exception {		
		this.userService.save(user);
		return new MsgDto(true, "添加成功");
	}
	
	@RequestMapping("save2")
	public MsgDto save2(User user,MultipartFile  img,HttpSession session) throws Exception {
		if(img!=null && !"".equals(img.getOriginalFilename())) {
		 
			String oldName=img.getOriginalFilename();
			 
			String ext=oldName.substring(oldName.lastIndexOf("."));
		 
			String newName=UUID.randomUUID()+ext;
			 
			String realpath= session.getServletContext().getRealPath("upload")+"/"+newName;
		 
			img.transferTo(new File(realpath));
			
		 
			user.setPhoto(newName);
			
		}
		
		this.userService.save(user);
		return new MsgDto(true, "添加成功");
	}
	 
	
	@RequestMapping("findUsers")
	public List<User> fingPages(UserDto userDto) {
		List<User> list=this.userService.findUsers(userDto); 
		return list;
	}
	 

}
