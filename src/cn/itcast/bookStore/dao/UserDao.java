package cn.itcast.bookStore.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.bookStore.domain.User;

public class UserDao extends HibernateDaoSupport{
	public void addUser(User user){
		this.getHibernateTemplate().save(user);
	}
	public User findUserByUsernameAndPassword(String username,String password){
		User u=new User();
		u.setUsername(username);
		u.setPassword(password);
		List<User> us=this.getHibernateTemplate().findByExample(u);
		if(us.size()==1){
			return us.get(0);
		}else{
			return null;
		}
	}
	public void updateUser(User user){
		this.getHibernateTemplate().update(user);
	}
	public User getUserById(int id){
		return this.getHibernateTemplate().get(User.class, id);
	}

}
