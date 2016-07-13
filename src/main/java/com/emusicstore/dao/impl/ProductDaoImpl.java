package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Repository
@Transactional    //spring knows to deal with this as a transaction
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;   //Autowired means that spring will inject in the manner described by
											 //applicationContext.xml

	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		//must flush so session operation is executed
		session.flush();
	}
	
	
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		//must flush so session operation is executed
		session.flush();
	}
	
	/*
	 * Get current session
	 * use session to get product class
	 * @see com.emusicstore.dao.ProductDao#getProductById(java.lang.String)
	 */
	public Product getProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		//Asks spring to find a product with the unique id and return as Object type
		//Needs casting since it is Object type
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		
		return product;
	}
	/*
	 * 
	 * */
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		
		
		return products;
	}

	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();
	}
	
	
	
}