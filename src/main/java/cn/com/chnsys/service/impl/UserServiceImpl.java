package cn.com.chnsys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.chnsys.mapper.UserMapper;
import cn.com.chnsys.pojo.User;
import cn.com.chnsys.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermapper;
	@Override
	public List<User> login(User user) {
		return usermapper.login(user);
	}
	/**
	 * ���������û���Ϣ
	 */
	@Override
	public List<User> findAllUser() {
		return usermapper.findAllUser();
	}
	/**
	 * �����û���Ϣ
	 */
	@Override
	public void save(User user) {
		usermapper.save(user);
	}
	/**
	 * ���IDɾ���û���Ϣ
	 */
	@Override
	public boolean delUser(int id) {
		boolean flag = usermapper.delUser(id);
		if(flag){
			return true;
		}
		return false;
	}
	/**
	 * ���ID�����û���Ϣ
	 */
	@Override
	public User findById(int id) {
		return usermapper.findById(id);
	}
	/**
	 * ���ID�����û���Ϣ
	 */
	@Override
	public boolean updateUser(User user) {
		
		boolean flag = usermapper.updateUser(user);
		if(flag){
			return true;
		}
		return false;
	}
}
