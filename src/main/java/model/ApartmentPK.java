package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the apartment database table.
 * 
 */
@Embeddable
public class ApartmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String host;

	private String buildingNumber;

	private String street;

	private String flatNumber;

	private String city;

	public ApartmentPK() {
	}
	public String getHost() {
		return this.host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getBuildingNumber() {
		return this.buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public String getStreet() {
		return this.street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getFlatNumber() {
		return this.flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ApartmentPK)) {
			return false;
		}
		ApartmentPK castOther = (ApartmentPK)other;
		return 
			this.host.equals(castOther.host)
			&& this.buildingNumber.equals(castOther.buildingNumber)
			&& this.street.equals(castOther.street)
			&& this.flatNumber.equals(castOther.flatNumber)
			&& this.city.equals(castOther.city);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.host.hashCode();
		hash = hash * prime + this.buildingNumber.hashCode();
		hash = hash * prime + this.street.hashCode();
		hash = hash * prime + this.flatNumber.hashCode();
		hash = hash * prime + this.city.hashCode();
		
		return hash;
	}
}