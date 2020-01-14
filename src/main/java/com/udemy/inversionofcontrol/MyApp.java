package com.udemy.inversionofcontrol;

/**
 * Exemple d'implementation pour montrer l'interet de Spring
 * ici l'app n'est pas vraiment configurable car tout est codé en dur
 * Il serait cool de pouvoir lire la conf depuis un fichier de conf plutot que de changer le code
 * @author soffiane
 *
 */
public class MyApp {

	public static void main(String[] args) {
		//on travaille avec l'interface Coach pour pouvoir implementer
		//n'importe quel type de Coach
		Coach ballCoach = new BaseBallCoach();
		System.out.println(ballCoach.getDailyWorkout()); //Spend 30 minutes of batting practice
		ballCoach = new TrackCoach();
		System.out.println(ballCoach.getDailyWorkout()); //Spend 30 minutes to run
	}

}
