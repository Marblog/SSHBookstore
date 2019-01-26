package cn.itcast.bookStore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.bookStore.domain.Orderitem;
import cn.itcast.bookStore.domain.Orders;

public class OrderItemDao extends HibernateDaoSupport {
	public void addOrderItem(Orders order){
		Set<Orderitem> os=order.getOrderitems();
		for(Orderitem oi:os){
			this.getHibernateTemplate().save(oi);
		}

	}
	public List<Orderitem> findOrderItemByOrder(Orders order){
		return new ArrayList<Orderitem>(order.getOrderitems());
	}
	
	public void delOrderItems(String id){ 
		Orderitem oi=new Orderitem();
		oi.setId(Integer.valueOf(id));
		this.getHibernateTemplate().delete(oi);
	}
}
