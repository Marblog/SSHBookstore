package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bookStore.dao.OrderDao;
import cn.itcast.bookStore.domain.Orders;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderDao od=(OrderDao) ac.getBean("orderdao");
		List<Orders> l=od.findAllOrder();
	   for(Orders o:l){
		System.out.println(l);
	}
	}

}
