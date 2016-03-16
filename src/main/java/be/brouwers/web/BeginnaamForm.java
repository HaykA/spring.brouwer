package be.brouwers.web;

import org.hibernate.validator.constraints.NotBlank;

public class BeginnaamForm {
	@NotBlank 
	private String beginnaam;

	public String getBeginnaam() {
		return beginnaam;
	}

	public void setBeginnaam(String beginnaam) {
		this.beginnaam = beginnaam;
	}
	
	
}
