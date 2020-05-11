package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")

public class Book {
	
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(generator = "SEQ_BOOK")
	@SequenceGenerator(name = "SEQ_BOOK", sequenceName = "SEQ_BOOK", allocationSize = 1)
	private int id;
	
	@Column(name="titulo", nullable = false)
	private String title;
	
	@Column(name="genero")
	private String genre;
	
	@Column(name="anoPub")
	private Integer yearPub;
	
	@Column(name="qtdpags")
	private Integer qttPag;
	
	@Column(name="resenha")
	private String review;
	
	@Column(name="avaliacao")
	private Integer rating;
	
	@Column(name="inicioLeitura")
	private Date startRead;
	
	@Column(name="fimLeitura")
	private Date endRead;
	
	@ManyToOne
//	@JoinTable(name="BOOK")
	@JoinColumn(name="AUTOR")
	private Author author;
	
	
	//	@JoinTable(name="AUTHOR", joinColumns = @JoinColumn(name="nome"), 
	//	inverseJoinColumns = @JoinColumn(name="book"))
	
/**	public Book() {
	}
	
	public Book(int id, String title, String genre, Integer yearPub, Integer qttPag, String review, Integer rating,
			Date startRead, Date endRead, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.yearPub = yearPub;
		this.qttPag = qttPag;
		this.review = review;
		this.rating = rating;
		this.startRead = startRead;
		this.endRead = endRead;
		this.author = author;
	}
**/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Integer getYearPub() {
		return yearPub;
	}

	public void setYearPub(Integer yearPub) {
		this.yearPub = yearPub;
	}

	public Integer getQttPag() {
		return qttPag;
	}

	public void setQttPag(Integer qttPag) {
		this.qttPag = qttPag;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getStartRead() {
		return startRead;
	}

	public void setStartRead(Date startRead) {
		this.startRead = startRead;
	}

	public Date getEndRead() {
		return endRead;
	}

	public void setEndRead(Date endRead) {
		this.endRead = endRead;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}