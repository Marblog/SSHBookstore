package cn.itcast.bookStore.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private String id;
	private User user;
	private Double money;
	private String receiverAddress;
	private String receiverName;
	private String receiverPhone;
	private Integer paystate;
	private Timestamp ordertime;
	private Set orderitems=new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {}

	/** minimal constructor */
	public Orders(String id,Timestamp ordertime) {
		this.id=id;
		this.ordertime = ordertime;
	}

	/** full constructor */
	public Orders(String id,User user,Double money, String receiverAddress, String receiverName, String receiverPhone, Integer paystate,
			Timestamp ordertime, Set orderitems) {
		this.id=id;
		this.user=user;
		this.money = money;
		this.receiverAddress = receiverAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.paystate = paystate;
		this.ordertime = ordertime;
		this.orderitems = orderitems;
		this.id = id;
		this.user=user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public Integer getPaystate() {
		return paystate;
	}

	public void setPaystate(Integer paystate) {
		this.paystate = paystate;
	}

	public Timestamp getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}

	public Set getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", user=" + user + ", money=" + money + ", receiverAddress=" + receiverAddress
				+ ", receiverName=" + receiverName + ", receiverPhone=" + receiverPhone + ", paystate=" + paystate
				+ ", ordertime=" + ordertime +  "]";
	}
}