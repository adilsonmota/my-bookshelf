package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;


@Entity
@SecondaryTable(name="autor")
public class Author {
	
	@Id
	@Column(name="nome", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="author")
	private List<Book> book;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getlivro() {
		return book;
	}
	
}
