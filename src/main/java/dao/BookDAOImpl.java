package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Book;
import util.JpaUtil;

public class BookDAOImpl implements BookDAO{

	public void insert(Book book) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(book);
		
		tx.commit();
		ent.close();
	}

	public void change(Book book) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(book);
		
		tx.commit();
		ent.close();
	}

	public void remove(Book book) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(book);
		
		tx.commit();
		ent.close();
		
	}

	public Book search(Integer id) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Book book = ent.find(Book.class, id);
		
		return book;
	}

	public List<Book> listAll() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Book b");
		
		List<Book> book = query.getResultList();
	
		return book;
	}

	
}
