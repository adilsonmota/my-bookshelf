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
	
	private Book book;
	private Author author;
	
	private BookDAO bookDAO;
	private AuthorDAO authorDAO;
	
	private List<Book> bookList;
	
	public AccessBookBean() {
		
		this.book = new Book();
		this.author = new Author();
		
		this.bookDAO = new BookDAOImpl();
		this.authorDAO = new AuthorDAOImpl();
		
		this.bookList = new ArrayList<Book>();
		
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	
	public void registerBook() {
		try {
			this.book.setStartRead(sdf.parse(getStartRead()));
			this.book.setEndRead(sdf.parse(getEndRead()));
		}
		catch (Exception e) {
			System.out.println("Invalid date format");
		}
		this.book.setAuthor(author);
		this.bookDAO.insert(book);
		
		this.author.addBook(book);
		
		this.authorDAO.insert(author);
		
		this.book = new Book();
		this.author = new Author();
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

	public List<Book> getBookList() {
		return bookList;
	}
}
