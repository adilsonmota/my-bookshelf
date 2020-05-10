package dao;

import java.util.List;

import entities.User;

/**
 * 
 * @author Cleiton
 *
 *  UserDAO é uma interface, onde compartilha a chamada dos metodos, mas não os implementam.
 */

public interface UserDAO {
	
	public void insert(User user);
	
	public void change(User user);

	public void remove(User user);

	public User search(String cpf);

	public List<User> listAll();

}
