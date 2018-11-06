package br.com.filter.repository.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("filter");
		}
		
		return emf.createEntityManager();
	}
}
