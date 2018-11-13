package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Apartment;
import model.ApartmentPK;
import model.Message;
import model.Reservation;
import model.User;

public class DataAccess 
{	
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("airbnb");
	
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
		User result = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			result = manager.find(User.class, email);
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		
		return result;		
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
	
	public static boolean createUser(User user)  {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(user);
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
	
	public static boolean updateUser(User user) {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			manager.find(User.class, user.getEmail());
			manager.getTransaction().begin();
			manager.merge(user);
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
	
	public static boolean removeUser(User user)  {
		EntityManager manager = managerFactory.createEntityManager();
		User managed = null;
		try {
			manager.getTransaction().begin();
			if (!manager.contains(user)) {
			    managed = manager.merge(user);
			}
			manager.remove(managed);
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
	
	public static Apartment getApartmentById(ApartmentPK apartmentKey) {
		Apartment result = null;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			result = manager.find(Apartment.class, apartmentKey);
		} catch(Exception ex) {
			//logger.error("Exception in method getUserByEmail");
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	
		return result;		
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
	
	public static boolean createApartment(Apartment apartment)  {
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
	
	public static boolean updateApartment(Apartment apartment)  {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			manager.find(Apartment.class, apartment.getId());
			manager.getTransaction().begin();
			manager.merge(apartment);
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
	
	public static boolean removeApartment(Apartment apartment)  {
		EntityManager manager = managerFactory.createEntityManager();
		Apartment managed = null;
		try {
			manager.getTransaction().begin();
			if (!manager.contains(apartment)) {
			    managed = manager.merge(apartment);
			}
			manager.remove(managed);
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
	
	public static boolean createMessage(Message message) {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			User sender = manager.find(User.class, message.getSender().getEmail());
			User receiver = manager.find(User.class, message.getReceiver().getEmail());
			manager.getTransaction().begin();
			manager.persist(message);
			sender.addMessagesSent(message);
			receiver.addMessagesReceived(message);
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
	
	public static boolean createReservation(Reservation reservation) {
		EntityManager manager = managerFactory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(reservation);
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
	
	public static boolean removeReservation(Reservation reservation)  {
		EntityManager manager = managerFactory.createEntityManager();
		Reservation managed = null;
		try {
			manager.getTransaction().begin();
			if (!manager.contains(reservation)) {
			    managed = manager.merge(reservation);
			}
			manager.remove(managed);
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

}
