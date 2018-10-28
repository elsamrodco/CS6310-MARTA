package edu.gatech.cs6310.plazel01.hw5.manager;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final String DELIMITER = ",";
		String scenarioFile = args[0];
		MTSimEventManager eventManager = new MTSimEventManager();

		try {
			Scanner takeCommand = new Scanner(new File(scenarioFile));
			String[] tokens;

			do {
				String userCommandLine = takeCommand.nextLine();
				tokens = userCommandLine.split(DELIMITER);
				switch (tokens[0]) {
				case "add_depot":
					eventManager.addDepot(Integer.valueOf(tokens[1]), tokens[2], Double.valueOf(tokens[3]),
							Double.valueOf(tokens[4]));
					break;
				case "add_stop":
					eventManager.addStop(Integer.valueOf(tokens[1]), tokens[2], Integer.valueOf(tokens[3]),
							Double.valueOf(tokens[4]), Double.valueOf(tokens[5]));
					break;
				case "add_route":
					eventManager.addRoute(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]), tokens[3]);
					break;
				case "extend_route":
					eventManager.extendRoute(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
					break;
				case "add_bus":
					eventManager.addBus(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]),
							Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]), Integer.valueOf(tokens[5]),
							Integer.valueOf(tokens[6]), Integer.valueOf(tokens[7]), Integer.valueOf(tokens[8]));
					break;
				case "add_event":
					eventManager.addEvent(Integer.valueOf(tokens[1]), tokens[2], Integer.valueOf(tokens[3]));
					break;
				default:
					System.out.println(" command not recognized");
					break;
				}
			} while (takeCommand.hasNextLine());

			takeCommand.close();
			eventManager.executeSimulation(20);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
	}
}
