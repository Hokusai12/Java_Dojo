package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

	//ATTRIBUTES
	private String role;
    private ArrayList<String> securityIncidents;
    
    //GETTERS AND SETTERS
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	//CONSTRUCTORS
	public AdminUser(Integer id, String role) {
		super(id);
		securityIncidents = new ArrayList<String>();
		setRole(role);
	}


	//INTERFACE METHODS
	@Override
	public boolean assignPin(int pin) {
		if(pin < 100000 || pin > 999999) {
			return false;
		}
		setPin(pin);
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(id.equals(confirmedAuthID)) {
			return true;
		}
		authIncident();
		return false;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

	//CLASS METHODS
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
}
