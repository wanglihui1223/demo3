package com.newer.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.domain.User;
import com.newer.dto.UserDto;

public interface UserService {
	 
  public User  login(String name,String upwd);
  
 
  public PageInfo<User> findPages(UserDto userDto);
  
  
  public boolean save(User user);
  
 
  public boolean isExists(String name);
  
  public List<User> findUsers(UserDto userDto);
  
  public boolean delete(Integer id);

}
