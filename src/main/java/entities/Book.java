package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="livro")
public class Book {
	
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "S_BOOK")
	@SequenceGenerator(name = "S_BOOK", sequenceName = "S_BOOK", allocationSize = 1)
	private Long id;
	
	@Column(name="titulo", nullable = false)
	private String title;
	
	@Column(name="genero", nullable = false)
	private String genre;
	
	@Column(name="fstPubDate", nullable = false)
	private Date fstPubDate;
	
	@ManyToOne
	@JoinColumn(name="autor", nullable = false) 
	private Author author;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getFstPubDate() {
		return fstPubDate;
	}
	public void setFstPubDate(Date fstPubDate) {
		this.fstPubDate = fstPubDate;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}