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
	private List<Book> lstbooks = new ArrayList<Book>();
	

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
}
