/**
 * 
 */
package com.udemy.inversionofcontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Le conteneur Spring a deux principales fonctions: 
 * creer et gerer des objets (Inversion of Control) 
 * Injecter les dependances des objets (Dependancy Injection)
 * 
 * 3 maniere de le configurer : 
 * XML (legacy) 
 * Annotation (moderne) 
 * Code Java(moderne)
 * 
 * 1) configurer les beans -> XML (applicationContext.xml)
 * 2) creer un container -> ApplicationContext (ClassPath, ClassPathXML, Annotation, GenericWeb...) 
 * 3) recuperer les beans depuis le container -> context.getBean("bean id", Class.class);
 * 
 * Spring Bean = objet Java crée par le Conteneur Spring (IoC)
 * 
 * Pour passer d'un type de Coach a un autre, on modifie le fichier XML donc c'est plus configurable
 * 
 * @author soffiane
 *
 */
public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring conf file
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container with his dependancies
		Coach coach = context.getBean("myCoach",Coach.class);
		//call methods on bean
		System.out.println(coach.getDailyWorkout());
		//new method injected in the Coach constructor
		System.out.println(coach.getDailyFortune());
		//close context
		context.close();
	}

}
