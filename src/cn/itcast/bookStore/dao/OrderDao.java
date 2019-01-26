package cn.itcast.bookStore.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.bookStore.domain.Orders;
import cn.itcast.bookStore.domain.User;

public class OrderDao extends HibernateDaoSupport{
	
	public void addProduct(Orders order){
		this.getHibernateTemplate().save(order);
	}
	
	public List<Orders> findOrderByUser(User user){
		Orders o=new Orders();
		o.setUser(user);
		return this.getHibernateTemplate().findByExample(o);
	}
	public List<Orders> findAllOrder(){
		String sql="from Orders";
		return this.getHibernateTemplate().find(sql);
		
	}
	public void updateOrderState(String id){
		Orders o=this.findOrderById(id);
		o.setPaystate(1);
		this.getHibernateTemplate().update(o);
	}
	public List<Orders> findOrderByManyCondition(String id,String receiverName){
		String sql="from Orders o where 1=1 ";
		if(id!=null&&id.trim().length()>0){
			sql += " and o.id='"+id+"'";
			
		}
		if(receiverName!=null&&receiverName.trim().length()>0){
			sql+=" and o.receiverName='"+receiverName+"'";
		}
		return this.getHibernateTemplate().find(sql);
	}
	public void delOrderById(String id){
		Orders o=new Orders();
		o.setId(id);
		this.getHibernateTemplate().delete(o);
	}

	public Orders findOrderById(String id) {
		// TODO Auto-generated method stub
		String hql="from Orders where id='"+id+"'";
		return (Orders) this.getHibernateTemplate().find(hql).get(0);
	}

	
}
