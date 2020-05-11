package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTHOR")
public class Author {
	
	@Id
	@Column(name="nome", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="author")
//	@JoinTable(name="BOOK", joinColumns = @JoinColumn(name="AUTOR"),
//	inverseJoinColumns = @JoinColumn(name="LIVRO"))
	private List<Book> lstbooks = new ArrayList<Book>();;
	
//	@JoinTable(name="AUTHOR", joinColumns = @JoinColumn(name="nome"), 
//			inverseJoinColumns = @JoinColumn(name="book"))
	
	public Author() {
	}

	public Author(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBook() {
		return lstbooks;
	}
	
	public void addBook(Book book) {
		lstbooks.add(book);
	}
	
	public void removeBook(Book book) {
		lstbooks.remove(book);
	}
	
	@Override
	public String toString() {
		String listando = null;
		for (Book book : lstbooks) {
			listando = "Dados do Livro: " + book.getTitle() +" | "+ book.getAuthor() +" | "+ book.getRating() + "Nome do Autor: " + getName();
		}
		return listando;
	}
}
