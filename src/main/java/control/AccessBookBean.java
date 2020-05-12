package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

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
	
	private String keyword;
	private String startRead;
	private String endRead;
	
	private Book book;
	private Author author;
	
	private BookDAO bookDAO;
	private AuthorDAO authorDAO;
	
	private List<Book> lstbooks = new ArrayList<Book>();
	
	public AccessBookBean() {
		
		this.book = new Book();
		this.author = new Author();
		
		this.bookDAO = new BookDAOImpl();
		this.authorDAO = new AuthorDAOImpl();
		
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	
	public void registerBook() {
		
		Author newAuthor = new Author();	
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
		newAuthor.setName(this.author.getName());
		
		newBook.setAuthor(newAuthor);		
		newAuthor.addBook(newBook);			

		this.authorDAO.insert(newAuthor);
		this.bookDAO.insert(newBook);
		
		this.book = new Book();
		this.author = new Author();
		this.startRead = null;
		this.endRead = null;
	}

	public void searchBook() {
		
		this.lstbooks = this.bookDAO.listAll();
		
		boolean msg = false;
		
		for (Book listlstbooks : lstbooks) {
			if (	(listlstbooks.getTitle().equals(keyword) ||
					listlstbooks.getAuthor().getName().equals(keyword)) ||
					listlstbooks.getGenre().equals(keyword)	) {
				msg = true;
			} 
		}
		
		if (msg) {
			
				
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Nada encontrado!"));
		}
		
	
		
		
		
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

	public List<Book> getlstbooks() {
		return lstbooks;
	}

	public void setlstbooks(List<Book> lstbooks) {
		this.lstbooks = lstbooks;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
