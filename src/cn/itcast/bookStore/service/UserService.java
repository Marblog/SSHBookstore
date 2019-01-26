package cn.itcast.bookStore.service;

import javax.security.auth.login.LoginException;

import cn.itcast.bookStore.dao.UserDao;
import cn.itcast.bookStore.domain.User;

public class UserService {
	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public User login(String username,String password) throws LoginException{
		User user=dao.findUserByUsernameAndPassword(username, password);
		if(user!=null){
			if(user.getState()==1){
				return user;
			}
			throw new RuntimeException("用户未激活");
		}
		throw new RuntimeException("用户名或密码错误");
	}

}
