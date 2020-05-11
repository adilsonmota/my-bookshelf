package dao;

import java.util.List;

import entities.Author;

public interface AuthorDAO {

	public void insert(Author author);
	public void change(Author author);
	public void remove(Author author);
	public Author search(String name);
	public List<Author> listAll();
}