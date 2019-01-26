package cn.itcast.bookStore.domain;



/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Orders orders;
     private Products products;
     private Integer buynum;


    // Constructors

    /** default constructor */
    public Orderitem() {
    }

    
    /** full constructor */
    public Orderitem(Orders orders, Products products) {
       this.orders=orders;
       this.products=products;
       
    }
    /** full constructor */
    public Orderitem(Orders orders, Products products,Integer buynum) {
       this.orders=orders;
       this.products=products;
       this.buynum=buynum;
       
    }


   
    // Property accessors




	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", orders=" + orders + ", products=" + products + ", buynum=" + buynum + "]";
	}


	public Integer getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Orders getOrders() {
		return this.orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public Products getProducts() {
		return this.products;
	}


	public void setProducts(Products products) {
		this.products = products;
	}


	public Integer getBuynum() {
		return this.buynum;
	}


	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}
   








}