package com.udemy.inversionofcontrol;

import com.udemy.dependancyinjection.FortuneService;

/**
 * Une implmentation de Coach
 * 
 * @author soffiane
 *
 */
public class TrackCoach implements Coach {

	// service that will be injected by Spring
	private FortuneService fortuneService;

	// constructor for injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	// need the no-arg constructeurs for the setter injection
	public TrackCoach() {
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes to run";
	}

	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}

	// define init methods
	public void doMyStartStuff() {
		System.out.println("TrackCoach : calling init method doMyStartStuff");
	}

	// define destroy methods
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach : calling destroy method doMyCleanupStuff");
	}

}
