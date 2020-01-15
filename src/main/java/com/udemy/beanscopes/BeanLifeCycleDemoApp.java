package com.udemy.beanscopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.dependancyinjection.CricketCoach;
import com.udemy.inversionofcontrol.Coach;
import com.udemy.inversionofcontrol.TrackCoach;

/**
 * 
 * Lifecycle Bean instancié -> dependances injectée -> internal spring process
 * bean factory -> custom init method -> READY container shutdown -> custom
 * destroy method On peut definir des methodes custom appelée à la
 * creation/destrction du Spring container dans MXL <bean .... init-method
 * ="myMethod" / destroy-method="myMethod"
 * 
 * Pas de destroyMethod pour les beans prototype !!!!
 * Il faut gerer à la main les actions de cleanup à la fermeture du context
 * 
 * @author soffiane
 *
 */
public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load the spring conf file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifeCycleApplicationContext.xml");
		// retrieve bean from spring container with his dependancies
		Coach coach = context.getBean("myCoach", TrackCoach.class);
		// call methods on bean
		System.out.println(coach.getDailyWorkout());
		// new method injected in the Coach constructor
		System.out.println(coach.getDailyFortune());
		// close context
		context.close();
	}

}
