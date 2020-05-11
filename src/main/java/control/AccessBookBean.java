package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AuthorDAO;
import dao.AuthorDAOImpl;
import dao.BookDAO;
import dao.BookDAOImpl;
import entities.Author;
import entities.Book;

@ManagedBean(name="AccesBookBean")
@SessionScoped

public class AccessBookBean {
	
	private SimpleDateFormat sdf;
	
	private String startRead;
	private String endRead;
	private String authorName;
	
	private Book book;
	private Author author;
	
	private BookDAO bookDAO;
	private AuthorDAO authorDAO;
	
//	private List<Book> bookList;
	
	public AccessBookBean() {
		
		this.book = new Book();
		this.author = new Author();
		
		this.bookDAO = new BookDAOImpl();
		this.authorDAO = new AuthorDAOImpl();
		
//		this.bookList = new ArrayList<Book>();
		
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	
	public void registerBook() {
		
		Author newAuthor = new Author(authorName);	// insere o nome no objeto Author
		Book newBook = new Book();
		
				
		
		newBook.setTitle(this.book.getTitle());
		newBook.setGenre(this.book.getGenre());
		newBook.setYearPub(this.book.getYearPub());
		newBook.setQttPag(this.book.getQttPag());
		newBook.setReview(this.book.getReview());
		newBook.setRating(this.book.getRating());
		try {
			newBook.setStartRead(sdf.parse(startRead));
			newBook.setEndRead(sdf.parse(endRead));
		}
		catch (Exception e) {
			System.out.println("Invalid date format");
		}
		
		
		
		newBook.setAuthor(newAuthor);		// insere um Objeto Author no Objeto Book
		newAuthor.addBook(newBook);			// insere na Lista de Livro do Author o Objeto Livro
		
		System.out.println("Dados do Autor: ");
		System.out.println(newAuthor.getName());
		System.out.println(newBook.getAuthor().getBook().get(0));
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Dados do livro: ");
		System.out.println(newBook.getTitle() +"|"+ newBook.getQttPag() +"|"+ newBook.getAuthor().getName()+"|"+ newBook.getAuthor().getBook());
		System.out.println("-------------------------------------------------------------------");
		this.authorDAO.insert(newAuthor);
		this.bookDAO.insert(newBook);
		
		this.book = new Book();
		this.author = new Author();
	}


	
	
	public String getauthorName() {
		return authorName;
	}


	public void setauthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getStartRead() {
		return startRead;
	}


	public void setStartRead(String startRead) {
		this.startRead = startRead;
	}


	public String getEndRead() {
		return endRead;
	}


	public void setEndRead(String endRead) {
		this.endRead = endRead;
	}


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

/**	public List<Book> getBookList() {
		return bookList;
	}
**/
}
