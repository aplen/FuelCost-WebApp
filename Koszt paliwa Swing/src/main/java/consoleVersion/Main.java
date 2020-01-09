package consoleVersion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	var trip = new Trip();
	var fuelCost = new FuelCost();
	ConsoleReader cr = new ConsoleReader();
	cr.retrieveDataTo(trip);
	fuelCost.calculateFuelCost(trip);
	DataViewer dv = new DataViewer();
	dv.viewData(trip, fuelCost.getCost());

	System.out.println("Wybierz 't' żeby zakończyć lub dowolny znak, żeby zacząć nowe wyliczenie");

	Scanner scan = new Scanner(System.in);
	String answer = scan.nextLine();

	if (!answer.equals("t")) {

	    Main.main(args);
	}

	else {
	    scan.close();
	}
    }

}
