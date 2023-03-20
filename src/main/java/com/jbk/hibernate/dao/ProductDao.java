package com.jbk.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;

public class ProductDao {
	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public boolean saveProduct(Product product) {

		Session session = sessionFactory.openSession();
		try {
			Product dbProduct = getProductById(product.getProductId());
			if (dbProduct == null) {

				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;

	}

	public Product getProductById(long productId) {
		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return product;

	}

	public boolean deleteProductById(long productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted=false;
		try {
			Product dbProduct=getProductById(productId);
			if (dbProduct!=null) {
				
			
			session.delete(dbProduct);
			transaction.commit();
			isDeleted=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated=false;
		
		try {
			Product dbProduct=getProductById(product.getProductId());
			if(dbProduct!=null) {
				
			
			session.update(product);
			transaction.commit();
			isUpdated=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.clear();
		}
		return isUpdated;
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria = session.createCriteria(Product.class);//depricated method//outdated
			list = criteria.list();
			/*
			 * CriteriaBuilder builder = session.getCriteriaBuilder();
			 * CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
			 * orderList = (List<Product>) criteria.from(Product.class);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public List<Product> getAllProductByAsendingOrderByName() {
		Session session = sessionFactory.openSession();
		List <Product> list=null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return list;
	}

	public List<Product> getAllProductByDesendingOrderByName() {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.desc("productName"));
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	public List<Product> getAllGtProduct(double productPrice) {
		Session session = sessionFactory.openSession();
		List<Product>list=null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", productPrice));
			list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return list;
	}

	public List<Product> getAllLtProduct(double productPrice) {
		Session session = sessionFactory.openSession();
		List<Product>list=null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.lt("productPrice",productPrice));
			list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	public List<Product> getAllCharProduct(String stringChar) {
		Session session = sessionFactory.openSession();
		List<Product> list=null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", stringChar));
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

}