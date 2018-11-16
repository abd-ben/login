package jsfBean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Ajax;

import com.User;
import service.ServiceUser;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean {

	User user = new User();
	ServiceUser su = new ServiceUser();

	public UserBean() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void login() {
		User userTemp = su.getUserByLoginPass(user.getLogin(), user.getPassword());
		if (userTemp != null) {
			this.user = userTemp;
			HttpSession session = getSession();
			session.setAttribute("user", userTemp);
			// Faces.getContext(). "admin/index.xhtml?faces-redirect=true";
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void logout() {
		System.out.println("---- LogOut-----");
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.invalidateSession();
		try {
			externalContext.redirect(externalContext.getRequestContextPath() + "/faces/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static void clearSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public boolean isLogged() {
		return getSession().getAttribute("user") != null ? false : true;
	}

}
