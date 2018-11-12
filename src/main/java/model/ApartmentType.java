package model;

public enum ApartmentType {
	PRIVATE_ROOM ("PRIVATE_ROOM"), //default
    ENTIRE_APARTMENT ("ENTIRE_APARTMENT"),
    SHARED_ROOM ("SHARED_ROOM");

    private final String name;       

    private ApartmentType(String n) {
        name = n;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
    
    public static ApartmentType fromString(String type) {
    	if (type.toUpperCase().contains("ENTIRE")) {
    		return ApartmentType.ENTIRE_APARTMENT;
    	} else if (type.toUpperCase().contains("PRIVATE")) {
    		return ApartmentType.PRIVATE_ROOM;
    	} else if (type.toUpperCase().contains("SHARED")) {
    		return ApartmentType.SHARED_ROOM;
    	} else {
    		return ApartmentType.PRIVATE_ROOM;
    	}
    }

}
