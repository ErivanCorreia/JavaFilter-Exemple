package br.com.filter.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletResponse;

import br.com.filter.entity.User;
import br.com.filter.exception.InvalidUserException;
import br.com.filter.repository.utils.JPAUtils;

public class UserRepository {
	
	private static JPAUtils instance;
	private EntityManager entityManager;
	
	public static JPAUtils getInstance() {
		if(instance == null) {
			instance = new JPAUtils(); 
		}
		
		return instance;
	}
	
	public UserRepository() {
		this.entityManager = JPAUtils.getEntityManagerFactory();
	}
	
	public void save(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public User findUser(User user) {
		
		User userAthenticated = null;
		try {
			
			userAthenticated = (User) entityManager
					.createQuery("SELECT u FROM User u WHERE u.username LIKE :user AND u.password LIKE :pass")
					.setParameter("user", user.getUsername())
					.setParameter("pass", user.getPassword())
					.getSingleResult();
			
			
		}catch(NoResultException e) {
			entityManager.getTransaction().rollback();
		}
		return userAthenticated;
		
		
	}
	
	
}
