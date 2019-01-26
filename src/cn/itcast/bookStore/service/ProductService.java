package cn.itcast.bookStore.service;

import java.util.List;

import cn.itcast.bookStore.dao.ProductDao;
import cn.itcast.bookStore.domain.Products;

public class ProductService {
	private ProductDao dao;

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}
	public void addProduct(Products p){
		dao.addProduct(p);
	}
	public List<Products> listAll(){
		return dao.listAll();
		
	}
	public Products findProductById(String id){
		return dao.findProductsById(id);
	}
	public List<Products> findProductByManyCondition(String id,String name,String category,String minprice,String maxprice){
		List<Products> ps=null;
		ps=dao.findProductByManyCondition(id, name, category, minprice, maxprice);
		return ps;
	}
	public void editProduct(Products p){
		dao.editProduct(p);
	}
	public void deleteProduct(String id){
		dao.deleteProduct(id);
	}

}
