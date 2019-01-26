package cn.itcast.bookStore.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.bookStore.domain.Orders;
import cn.itcast.bookStore.service.OrderService;

public class OrderAction extends ActionSupport{
	private OrderService orderservice;

	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}
	public String findOrders() throws Exception{
		List<Orders> orders=orderservice.findAllOrder();
		ServletActionContext.getRequest().setAttribute("orders",orders);
		return "success";
	}
	private String id;
	private String receiverName;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String findOrderByManyCondition() throws Exception{
		List<Orders> orders=orderservice.findOrderByManyCondition(id, receiverName);
		ServletActionContext.getRequest().setAttribute("orders",orders);
		return "success";
	}
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String findOrderById() throws Exception{
		Orders orders=orderservice.findOrderById(id);
		ServletActionContext.getRequest().setAttribute("order",orders);
		return "success";
	}
	public String delOrderById() throws Exception{
		orderservice.delOrderById(id);
		return "success";
	}
}
