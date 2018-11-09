package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Apartment;
import model.Message;
import model.User;

public class DataAccess 
{	
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("airbnb");
	
	public static List<User> test() {
		System.out.println("TEST INCOMING");
		List<User> results;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("User.findAll", User.class);
			results = query.getResultList();
		} finally {
			manager.close();
		}
		System.out.println("TEST");
		System.out.println(results);
		return results;
	}
	
	public static List<User> getAllUsers() {
		List<User> results;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("User.findAll", User.class);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getAllUsers");
			ex.printStackTrace();
			results = new ArrayList();
		} finally {
			manager.close();
		}
		return results;
	}
	
	public static User getUserByEmail(String email) throws IllegalStateException {
		List<User> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("User.findByEmail", User.class);
			query.setParameter("email", email);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		if (results == null || results.isEmpty()) {
			return null;
		}
		
		if (results.size() > 1) {
			throw new IllegalStateException("PK duplicate in User table");
		}
		
		
		return results.get(0);		
	}
	
	public static List<User> getUsersBySurname(String surname) {
		List<User> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("User.findBySurname", User.class);
			query.setParameter("surname", surname);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return results;
	}
	
	public static List<Apartment> getAllApartments() {
		List<Apartment> results;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("Apartment.findAll", Apartment.class);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getAllUsers");
			ex.printStackTrace();
			results = new ArrayList();
		} finally {
			manager.close();
		}
		return results;
	}
	
	public static List<Apartment> getApartmentByHost(String email) {
		List<Apartment> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("Apartment.findByHost", Apartment.class);
			query.setParameter("host", email);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return results;
	}
	
	public static List<Apartment> getApartmentByName(String name) {
		List<Apartment> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("Apartment.findByName", Apartment.class);
			query.setParameter("name", name);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return results;
	}
	
	public static List<Apartment> getApartmentByCountry(String country) {
		List<Apartment> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("Apartment.findByCountry", Apartment.class);
			query.setParameter("country", country);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return results;
	}
	
	public static List<Apartment> getApartmentByCity(String city) {
		List<Apartment> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("Apartment.findByCity", Apartment.class);
			query.setParameter("city", city);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return results;
	}
	
	public static List<Apartment> getApartmentCheaperThan(double limit) {
		List<Apartment> results = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("Apartment.findCheaperThan", Apartment.class);
			query.setParameter("price", limit);
			results = query.getResultList();
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return results;
	}
	
	public boolean createApartment(Apartment apartment)  {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(apartment);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (manager.getTransaction().isActive()) {
					manager.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			manager.close();
		}
		return true;
	}
	
	public static List<Message> getUserMessages(User user) {
		return null;
	}
	
	/*public static List<Trip> getUserTrips(User user) {
		return null;
	}*/
	

}
