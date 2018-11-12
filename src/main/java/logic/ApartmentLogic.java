package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.DataAccess;
import model.Apartment;
import model.Reservation;

public class ApartmentLogic {
	
	public static void addApartment(Apartment apartment) {
		if (!UserLogic.isUserRegistered(apartment.getHost())) {
			UserLogic.createUser(apartment.getHost());
		}
		
		DataAccess.createApartment(apartment);
	}
	public static List<Apartment> search(String fromPlace, String price, String typeOfAccom, Integer adults, Integer children, Date dateStart, Date dateEnd){
		
		List<Apartment> availableApartmentsList = DataAccess.getAllApartments();
		List<Apartment> resultApartmentsList = new ArrayList<Apartment>();
		
		for(Apartment apartment : availableApartmentsList) {
			
			if(checkApartmentName(apartment, fromPlace)==true && checkApartmentPrice(apartment, price)==true && checkApartmentType(apartment, typeOfAccom)==true &&
					checkApartmentBeds(apartment, adults, children)==true && checkApartmentDates(apartment, dateStart, dateEnd)==true) {
					
					resultApartmentsList.add(apartment);
			}
				
		}
		
		return resultApartmentsList;
	}
	
	private static boolean checkApartmentName(Apartment apartment, String obtainedName) {
		
		if(obtainedName.contains(apartment.getCity().toLowerCase())==true ){
			
			return true;
		}
		else if(obtainedName.contains(apartment.getCountry().toLowerCase())==true) {
			
			return true;
		}
		else if(obtainedName.equals("")) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	private static boolean checkApartmentPrice(Apartment apartment, String price) {
		
		double pricePerDay = apartment.getPrice();
		
		if(price == null){
			
			return true;
		}
		else if(price.equals("P1")==true && pricePerDay < 35) {
			
			return true;
		}
		else if(price.equals("P2")==true && pricePerDay >= 35 && pricePerDay < 70) {
			
			return true;
		}
		else if(price.equals("P3")==true && pricePerDay >= 70 && pricePerDay < 131) {
			
			return true;
		}
		else if(price.equals("P4")==true && pricePerDay >= 131) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	private static boolean checkApartmentType(Apartment apartment, String typeOfAccom) {
		
		
		if(typeOfAccom == null) {
			
			return true;
		}
		else if(apartment.getType().equals(typeOfAccom)==true){
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
	private static boolean checkApartmentBeds(Apartment apartment, Integer numberOfAdults, Integer numberOfChildren) {
		
		Integer bedsForAdults = new Integer(apartment.getBedsAdult());
		Integer bedsForChildren = new Integer(apartment.getBedsChild());
		
		if(numberOfAdults == null && numberOfChildren == null){
			
			return true;
		}
		else if(numberOfAdults <= bedsForAdults && numberOfChildren <= bedsForChildren){
			
			return true;
		}
		else if(numberOfAdults <= bedsForAdults && numberOfChildren == null) {
		
			return true;
		}
		else if(numberOfAdults == null && numberOfChildren <= bedsForChildren){
			
			return true;
		}
		else {
			
			return false;
		}
	}
	private static boolean checkApartmentDates(Apartment apartment, Date dateStart, Date dateEnd) {
		
		List<Reservation> reservations = apartment.getReservations();
		
		List<Date> bookedDays = new ArrayList<Date>();
		
		for(Reservation reservation : reservations) {
		
			bookedDays.add(reservation.getDate());
		}
		
		if(dateStart != null && dateEnd != null) {
			
			if(dateStart.before(dateEnd)==true) {
				
				for(Date date : bookedDays) {
					
					if(isDateBetweenTwoDates(dateStart, dateEnd, date)==true) {
						
						return false;
					}
				}
				
				return true;
			}
			
			else {
				
				return true;
			}
		}
		
		else if (dateStart != null && dateEnd == null) {
			
			for(Date date : bookedDays) {
				
				if((date.compareTo(dateStart) >= 0)==true) {
					
					return false;
				}
			}
			
			return true;
			
		}
			
		else if(dateStart == null && dateEnd != null) {
			
			Date currentDate = new Date(new java.util.Date().getTime());
			
			for(Date date : bookedDays) {
				
				if(isDateBetweenTwoDates(currentDate, dateEnd, date)==true) {
					
					return false;
				}
			}
			
			return true;
		}
		
		else {
		
			return true;
		}
		
		
	}
	private static boolean isDateBetweenTwoDates(Date dateStart, Date dateEnd, Date examinedDate) {
		
		return dateStart.compareTo(examinedDate) * dateEnd.compareTo(examinedDate) <= 0;

	}
}
