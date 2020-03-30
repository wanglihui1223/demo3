package com.newer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.UserDao;
import com.newer.domain.User;
import com.newer.dto.UserDto;
import com.newer.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String name, String upwd) {
		 
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("name", name);
		criteria.andEqualTo("upwd", upwd);
	 
		User user = this.userDao.selectOneByExample(example);
		return user;
	}

	@Override
	public PageInfo<User> findPages(UserDto userDto) {
		 
		PageHelper.startPage(userDto.getPage(), userDto.getPageSize());
		 
		List list = this.findUsers(userDto);
		PageInfo pageInfo=new PageInfo(list);
		return pageInfo;
	}

	@Override
	public boolean save(User user) { 
		return this.userDao.insert(user)>0?true:false;
	}
	 

	@Override
	public boolean isExists(String name) {
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("uname", name);
		User user=this.userDao.selectOneByExample(example);
		return user!=null?true:false;
	}

	@Override
	public List<User> findUsers(UserDto userDto) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		if (userDto.getName() != null && !"".equals(userDto.getName())) {
			criteria.andLike("uname", "%" + userDto.getName() + "%");
		}
		if (userDto.getSex() != null) {
			criteria.andEqualTo("sex", userDto.getSex());
		}
		List list = this.userDao.selectByExample(example);
	 
		return list;
	}

}
