package com.udemy.beanscopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.dependancyinjection.CricketCoach;
import com.udemy.inversionofcontrol.Coach;
import com.udemy.inversionofcontrol.TrackCoach;

/**
 * Java bean lifecycle :
 * duree de vie du bean 
 * nombre d'instance 
 * partage du bean
 * scope par defaut est singleton -> une seule instance mis en cache
 * 
 * There are five types of spring bean scopes:
 * 
 * singleton – only one instance of the spring bean will be created for the
 * spring container. This is the default spring bean scope. While using this
 * scope, make sure bean doesn’t have shared instance variables otherwise it
 * might lead to data inconsistency issues. 
 * prototype – A new instance will be created every time the bean is requested from the spring container. 
 * request – This is same as prototype scope, however it’s meant to be used for web
 * applications. A new instance of the bean will be created for each HTTP
 * request. 
 * session – A new bean will be created for each HTTP session by the container. 
 * global-session – This is used to create global session beans for Portlet applications.
 * 
 * 
 * @author soffiane
 *
 */
public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring conf file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		// retrieve bean from spring container with his dependancies
		Coach coach = context.getBean("myCoach", TrackCoach.class);
		//create another TrackCoach via Spring Factory
		Coach coachBis = context.getBean("myCoach", TrackCoach.class);
		//scope of myCoach Bean is singleton so coach == coachBis
		System.out.println(coach == coachBis);

		// retrieve bean from spring container with his dependancies
		Coach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		Coach cricketCoachBis = context.getBean("myCricketCoach", CricketCoach.class);
		//scope of myCricketCoach is prototype so cricketCoach != crocketCoachBis
		System.out.println(cricketCoach == cricketCoachBis);
		// close context
		context.close();
	}

}
