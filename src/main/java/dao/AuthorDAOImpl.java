package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Author;
import util.JpaUtil;

public class AuthorDAOImpl implements AuthorDAO {

	public void insert(Author author) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(author);
		
		tx.commit();
		ent.close();
	}

	public void change(Author author) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(author);
		
		tx.commit();
		ent.close();
	}

	public void remove(Author author) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(author);
		
		tx.commit();
		ent.close();
	}

	public Author search(String name) {

		EntityManager ent = JpaUtil.getEntityManager();
		Author author = ent.find(Author.class, name);
		
		return author;
	}

	public List<Author> listAll() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Author u");
		
		List<Author> author = query.getResultList();
	
		return author;
	}

}
