package com.udemy.inversionofcontrol;

import com.udemy.dependancyinjection.FortuneService;

/**
 * Une implementation de Coach
 * 
 * @author soffiane
 *
 */
public class BaseBallCoach implements Coach {
	
	//private field for the dependancy
	private FortuneService fortuneService;
	
	//define a constructor for dependancy injection
	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	//need the no-arg constructeurs for the setter injection
	public BaseBallCoach() {
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes of batting practice";
	}

	public String getDailyFortune() {
		//use my fortuneservice to get the fortune using the helper
		return fortuneService.getFortune();
	}

}
