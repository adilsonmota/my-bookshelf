package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UserDAO;
import dao.UserDAOImpl;
import entities.User;

@ManagedBean(name="LoginBean")
@SessionScoped

public class LoginBean {
	
	private String usrLogin;
	private String pswLogin;
	
	private List<User> registeredUsers;
	private User user;
	
	private UserDAO userDAO;
		
	public LoginBean() {
		this.registeredUsers = new ArrayList<User>();
		this.user = new User();
		this.userDAO = new UserDAOImpl();
	}
	
	public void registerUser() {
		
		boolean msg = true;
		
		this.registeredUsers = this.userDAO.listAll();
		
		for (User listUsers : registeredUsers) {
			if (	(listUsers.getUsername().equals(this.user.getUsername())) ||
					(listUsers.getEmail().equals(this.user.getEmail())) ||
					(listUsers.getCpf().equals(this.user.getCpf()))	) {
				msg = false;
			}
		}
		
		if (msg) {
			this.userDAO.insert(user);
			this.user = new User();
//			showMessage(true);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!"));
//			showMessage(msg);
		}
	}
	
	public String login() {
		
		boolean msg = false;

		this.registeredUsers = this.userDAO.listAll();
		
		for (User listUsers : registeredUsers) {
			if (	(listUsers.getUsername().equals(usrLogin) && listUsers.getPassword().equals(pswLogin))	) {
				msg = true;
			} 
		}
		
		if (msg) {
//			showMessage(true);
			return "searchBook.xhtml";
		} else {
//			showMessage(false);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Verifique Usuário ou Senha!"));
		}
		return null;
	}
	
/**	
	public void showMessage(boolean msg) {
		if (msg) {
			System.out.println("Sucesso na requisição!!!");
		} else {
			System.out.println("Requisição falhou!!!");
		}
	}
**/	
		
	public String getUsrLogin() {
		return usrLogin;
	}
	public void setUsrLogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}
	public String getPswLogin() {
		return pswLogin;
	}
	public void setPswLogin(String pswLogin) {
		this.pswLogin = pswLogin;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
