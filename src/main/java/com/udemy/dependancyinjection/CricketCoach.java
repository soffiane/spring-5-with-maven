/**
 * 
 */
package com.udemy.dependancyinjection;

import com.udemy.inversionofcontrol.Coach;

/**
 * Exemple pour injection par setter
 * 
 * @author soffiane
 *
 */
public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//add new fields for email adress and team
	private String emailAdress;
	private String team;
	
	//fields for field injection by reading property file
	private String firstname;
	private String lastname;

	// create a no-arg constructeur -needed for the setter injection
	public CricketCoach() {
		System.out.println("CricketCoach : Spring calling the no-arg constructor");
	}

	public String getDailyWorkout() {
		return "practice cricket";
	}

	public String getDailyFortune() {
		return "Cricket Fortune " + fortuneService.getFortune();
	}

	// property name=fortuneService dans applicationContext.xml
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach : Spring injecting the setter - setFortuneService");
		this.fortuneService = fortuneService;
	}

	//setter for fields injected by Spring in XML configuration file
	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		System.out.println("CricketCoach : Spring injecting the setter - setEmailAdress");
		this.emailAdress = emailAdress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach : Spring injecting the setter - setTeam");
		this.team = team;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
