package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class Person {
	private String name;

	public void setName(String value) {
		this.name = value;
	}

	@Id
	public String getName() {
		return this.name;
	}

	private RegistrationManager registrationManager;

	@ManyToOne(optional = false)
	public RegistrationManager getRegistrationManager() {
		return this.registrationManager;
	}

	public void setRegistrationManager(RegistrationManager registrationManager) {
		this.registrationManager = registrationManager;
	}

}
