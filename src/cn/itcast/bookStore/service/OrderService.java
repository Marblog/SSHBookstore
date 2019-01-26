package cn.itcast.bookStore.service;

import java.util.HashSet;
import java.util.List;

import cn.itcast.bookStore.dao.OrderDao;
import cn.itcast.bookStore.dao.OrderItemDao;
import cn.itcast.bookStore.dao.ProductDao;
import cn.itcast.bookStore.domain.Orderitem;
import cn.itcast.bookStore.domain.Orders;
import cn.itcast.bookStore.domain.User;

public class OrderService {
	private OrderItemDao oidao;
	private OrderDao odao;
	private ProductDao pdao;
	public void setOidao(OrderItemDao oidao) {
		this.oidao = oidao;
	}
	public void setOdao(OrderDao odao) {
		this.odao = odao;
	}
	public void setPdao(ProductDao pdao) {
		this.pdao = pdao;
	}
	public void addOrder(Orders order){
		odao.addProduct(order);
		oidao.addOrderItem(order);
		pdao.changProductNum(order);
	}
	public List<Orders> findOrderByUser(User user){
		List<Orders> orders=null;
		orders=odao.findOrderByUser(user);
		return orders;
	}
	public Orders findOrderById(String id){
		Orders order=null;
		order=odao.findOrderById(id);
		List<Orderitem> items=oidao.findOrderItemByOrder(order);
		order.setOrderitems(new HashSet(items));
		return order;
	}
	public List<Orders> findAllOrder(){
		List<Orders> orders=null;
		orders=odao.findAllOrder();
		return orders;
	}
	public void updateState(String id){
		odao.updateOrderState(id);
	}
	public List<Orders> findOrderByManyCondition(String id,String receiverName){
		List<Orders> orders=null;
		orders=odao.findOrderByManyCondition(id, receiverName);
		return orders;
	}
	public void delOrderById(String id){
		odao.delOrderById(id);
	}
	public void delOrderByIdWithClient(String id){
		Orders order=new Orders();
		order.setId(id);
		List<Orderitem> items=oidao.findOrderItemByOrder(order);
		pdao.updateProductNum(items);
		oidao.delOrderItems(id);
		odao.delOrderById(id);
		
	}
}
