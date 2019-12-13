package consoleVersion;

public class Main {

    public static void main(String[] args) {
	
	var fuelCost = new FuelCost();
	new ConsoleReader().retrieveData(fuelCost);
	fuelCost.setCost(fuelCost.calculateFuelCost());
	new DataViewer().viewData(fuelCost);
	
    }
}