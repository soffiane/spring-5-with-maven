package com.udemy.dependancyinjection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private List<String> fortunes;
	private String fileName = "/fortunes.txt";

	public RandomFortuneService() {
		File theFile = new File(this.getClass().getResource(fileName).getFile());

		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());

		// initialize array list
		fortunes = new ArrayList<String>();

		// read fortunes from file
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				fortunes.add(tempLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFortune() {
		Random r = new Random();
		int randomNumber = r.nextInt(fortunes.size());
		return fortunes.get(randomNumber);
	}

}
