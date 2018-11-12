package logic;

import database.DataAccess;
import model.Apartment;

public class ApartmentLogic {

	public static void addApartment(Apartment apartment) {
		if (!UserLogic.isUserRegistered(apartment.getHost())) {
			UserLogic.createUser(apartment.getHost());
		}
		
		DataAccess.createApartment(apartment);
	}
}
