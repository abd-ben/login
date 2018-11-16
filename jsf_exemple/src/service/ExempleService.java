package service;

import java.util.List;

import com.Exemple;

public class ExempleService extends Service<Exemple> {
	
	public void createExemple(Exemple exemple) {
		this.create(exemple);
	}
	public void deleteExemple(int id) {
		this.delete(Exemple.class, id);
	}
	public void updateExemple(Exemple exemple) {
		this.update(exemple);
	}
	public List<Exemple> findAllExemple() {
		return this.findAll("Exemple");
	}
	public Exemple findExempleById( int id) {
		return this.findById(Exemple.class, id);
	} 
}
