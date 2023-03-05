package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	//ATTRIBUTES
    private ArrayList<String> patientNotes;
	
	//CONSTRUCTORS
	public Physician(Integer id) {
		super(id);
	}
	
	//INTERFACE METHODS
	@Override
	public boolean assignPin(int pin) {
		//If given pin isn't 4 digits return false
		if(pin < 1000 || pin > 9999) {
			return false;
		}
		//Otherwise set user's pin to given pin and return true
		setPin(pin);
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(id.equals(confirmedAuthID)) {
			return true;
		}
		return false;
	}

	//CLASS METHODS
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
}
