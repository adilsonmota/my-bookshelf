package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.User;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementação ela recebe no construtor o entityManager,
 *  a conexão com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class UserDAOImpl implements UserDAO {
	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void insert(User user) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(user);
		
		tx.commit();
		ent.close();
	}

	/**
	 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
	 */
	public void change(User user) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(user);
		
		tx.commit();
		ent.close();
	}

	public void remove(User user) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(user);
		
		tx.commit();
		ent.close();
	}

	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o cpf
	 */
	public User search(String cpf) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		User user = ent.find(User.class, cpf);
		
		return user;
	}

	/**
	 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a consulta pelo objeto direto
	 * assim from User, que isso é o objeto usuario e não a tabela
	 */
	public List<User> listAll() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from User u");
		
		List<User> user = query.getResultList();
	
		return user;
	}
	
}
