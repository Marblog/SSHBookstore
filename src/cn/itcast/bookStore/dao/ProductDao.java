package cn.itcast.bookStore.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.bookStore.domain.Orderitem;
import cn.itcast.bookStore.domain.Orders;
import cn.itcast.bookStore.domain.Products;

public class ProductDao extends HibernateDaoSupport{
	public void addProduct(Products p){
		this.getHibernateTemplate().save(p);
	}
	public List<Products> listAll(){
		return this.getHibernateTemplate().find("from Products");
	}
	public int findAllCount(String category){
		String sql="select count(*) from Products p";
		if(!"全部商品".equals(category)){
			sql+=" where p.category='"+category+"'";
			
		}
		List list=this.getHibernateTemplate().find(sql);
		return new Long((Long) list.get(0)).intValue();
	}
	public List<Products> findByPage(int currentPage,int currentCount,String category){
		String sql=null;
		Object[] obj=null;
		if(!"全部商品".equals(category)){
			sql="from Products p where p.category='"+category+"'";
		}else{
			sql="from Products";
		}
		Session session=this.getSession();
		Query query=session.createQuery(sql);
		query.setMaxResults(currentCount);
		query.setFirstResult((currentPage-1)*currentCount);
		return query.list();
	}
	public Products findProductsById(String id)
	{
		Products p=this.getHibernateTemplate().get(Products.class, id);
		System.out.println(p);
		return p;
	}
	public void changProductNum(Orders order){
		Set<Orderitem> ois=order.getOrderitems();
		for(Orderitem oi:ois){
			Products p=oi.getProducts();
			p.setPnum(p.getPnum()-oi.getBuynum());
			this.getHibernateTemplate().update(p);
			
		}
	}
	public List<Object[]> salesList(String year,String month){
		String sql="select p.name,SUM(orderitem.bynum)"+
					"FROM Order orders,Products p,Orderitem orderitem "+
					"WHERE orders=orderitem.orders AND p=orderitem.products "+
					"AND orders.paystate=1 and year(orders.ordertime)='"+year+"'"
							+"and month(orders.ordertime)='"+month+"'"+
					"GROUP BY p.name";
		return this.getHibernateTemplate().find(sql);
	}
	public List<Products> findProductByManyCondition(String id,String name,String category,String minprice,String maxprice){
		String sql="from Products p where 1=1 ";
		if(id!=null&&id.trim().length()>0){
			sql+=" and p.id='"+id+"'";
			
		}
		if(name!=null&&name.trim().length()>0){
			sql+=" and p.name like '%"+name+"%'";
			
		}
		if(category!=null&&category.trim().length()>0){
			sql+=" and p.category like '%"+category+"%'";
			
		}
		if(minprice!=null&& maxprice!=null&&minprice.trim().length()>0&&maxprice.trim().length()>0){
			sql+=" and p.price between "+minprice+"and"+maxprice;
			
		}
		return this.getHibernateTemplate().find(sql);
		
	}
	public void updateProductNum(List<Orderitem> items){
		for(Orderitem oi:items){
			Products p=oi.getProducts();
			p.setPnum(p.getPnum()+oi.getBuynum());
			this.getHibernateTemplate().update(p);
		}
	}
	public void deleteProduct(String id){
		Products p=new Products();
		p.setId(id);
		this.getHibernateTemplate().delete(p);
	}
	public void editProduct(Products p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
		
	}
	
}
