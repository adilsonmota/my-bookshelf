package dao;

import java.util.List;

import entities.Book;

public interface BookDAO {

	public void insert(Book book);
	public void change(Book book);
	public void remove(Book book);
	public Book search(Integer id);
	public List<Book> listAll();
}
