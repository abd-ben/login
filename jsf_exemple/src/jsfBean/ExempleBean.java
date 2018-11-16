package jsfBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.Exemple;

import service.ExempleService;

@ManagedBean(name="exemplebean")
@SessionScoped
public class ExempleBean {
	
	Exemple exemple = new Exemple();
	ExempleService exempleService = new ExempleService();
	
	List<Exemple> exemples = new ArrayList<Exemple>();
	
	@PostConstruct
	public void onLoad() {
		exemples = exempleService.findAllExemple();
	}

	public Exemple getExemple() {
		return exemple;
	}
	public void setExemple(Exemple exemple) {
		this.exemple = exemple;
	}
	public List<Exemple> getExemples() {
		return exemples;
	}
	public void setExemples(List<Exemple> exemples) {
		this.exemples = exemples;
	}
	
}
