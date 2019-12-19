package consoleVersion;

public class Main {

    public static void main(String[] args) {
	var trip = new Trip();
	var fuelCost = new FuelCost();
	new ConsoleReader().retrieveData(trip);
	fuelCost.calculateFuelCost(trip);
	new DataViewer().viewData(trip, fuelCost.getCost());
	
    }
}