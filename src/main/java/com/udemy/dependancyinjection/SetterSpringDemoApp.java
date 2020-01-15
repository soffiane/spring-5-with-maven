package com.udemy.dependancyinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.inversionofcontrol.Coach;
import com.udemy.inversionofcontrol.TrackCoach;

/**
 * DI (Dependancy Injection) Le client delege l'appel a un autre objet la
 * responsabilité de lui fournir ses dependances
 * 
 * Exemple: acheter un Car -> appeler la Factory la Factory a les pieces de la
 * voiture et la voiture est construite par la Factory avant de la livrer au
 * client --> inject les pieces de la voitures par la Factory comparable a des
 * "helper objects" On delegue a Spring la taches de fabriquer l'objet et ses
 * dependances
 * 
 * Demo suite : le Coach donne des entrainement, il va maintenant donné des
 * "fortuneservice" on va creer le helper FortuneService (c'est une dependance
 * de Coach)
 * 
 * Injection via Spring : via construction (XML) via Setter (XML) --> aussi
 * Autowiring (annotation)
 * 
 * Etapes : 1) Creer l'interface et la classe de la dependance 2) Creer un
 * constructeur dans la classe Coach pour l'injection 3) Configurer l'injection
 * dans le fichier XML
 * 
 * @author soffiane
 *
 */
public class SetterSpringDemoApp {

	public static void main(String[] args) {

		// load the spring conf file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container with his dependancies
		Coach coach = context.getBean("myCoach", TrackCoach.class);
		// call methods on bean
		System.out.println(coach.getDailyWorkout());
		// new method injected in the Coach constructor
		System.out.println(coach.getDailyFortune());

		// retrieve bean from spring container with his dependancies
		// here we need the implementation to get Email and Team, not the interface
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		// call methods on bean
		System.out.println(cricketCoach.getDailyWorkout());
		// new method injected in the Coach constructor
		System.out.println(cricketCoach.getDailyFortune());
		// call methods to retrieve literal values via getter
		System.out.println(cricketCoach.getEmailAdress());
		System.out.println(cricketCoach.getTeam());
		// call methods to retrieve literal values via getter read from property file
		System.out.println(cricketCoach.getFirstname());
		System.out.println(cricketCoach.getLastname());
		// close context
		context.close();
	}

}
