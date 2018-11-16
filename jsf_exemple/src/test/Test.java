package test;

import java.util.ArrayList;
import java.util.List;

import com.Exemple;
import com.User;

import service.ExempleService;
import service.ServiceUser;

public class Test {

	public static void main(String[] args) {
		/*
		User user = new User("abd", "abd");
		ServiceUser serviceUser = new ServiceUser();
		
		serviceUser.create(user);
		*/
		
		ExempleService exempleService = new ExempleService();
		List<Exemple> exemples = new ArrayList<Exemple>();
 		
		exemples = exempleService.findAllExemple();
		
		exemples.forEach((exp) -> {
			System.out.println(exp.getNom());
		});
	}

}
