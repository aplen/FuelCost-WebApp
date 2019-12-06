package consoleVersion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {

    static void retrieveData() {
	Scanner scan = new Scanner(System.in);
	boolean isNotCorrect = true;
	double cost = 0;
	FuelCost fuelCost = new FuelCost();

	do {
	    try {
		System.out.print("Podaj szacowane średnie spalanie benzyny (w litrach/100km) w Twoim samochodzie \n"
			+ "wez pod uwagę charakter trasy, którą chcesz pokonać:");
		fuelCost.setPb95On100km(scan.nextDouble());
		System.out.print(
			"Podaj szacowane średnie spalanie LPG (w litrach/100km) w Twoim samochodzie \n"
			+ "wez pod uwagę charakter trasy, którą chcesz pokonać:");
		fuelCost.setLpgOn100km(scan.nextDouble());
		System.out.print("Ile kosztuje litr benzyny?");
		fuelCost.setPb95Price(scan.nextDouble());
		System.out.print("Ile kosztuje litr LPG?");
		fuelCost.setLpgPrice(scan.nextDouble());
		System.out.print("Ile km przejedziesz na LPG?");
		fuelCost.setKmOnLPG(scan.nextDouble());
		System.out.print("Ile km przejedziesz na benzynie?");
		fuelCost.setKmOnPB95(scan.nextDouble());

		cost = fuelCost.calculateFuelCost();
		if (cost < 0)
		    throw new InputMismatchException();
		isNotCorrect = false;
	    } catch (InputMismatchException e) {

		System.out.printf("Niepoprawny format danych, wprowadz ponownie\n");
	    }
	} while (isNotCorrect);

	scan.close();

	StringBuilder b = new StringBuilder();
	b.append("Cena LPG za 1 litr: ");
	b.append(fuelCost.getLpgPrice());
	b.append(" PLN\nCena benzyny za 1 litr: ");
	b.append(fuelCost.getPb95Price());
	b.append(" PLN\n");
	b.append(fuelCost.getKmOnLPG());
	b.append(" kilometrów na LPG\n");
	b.append(fuelCost.getKmOnPB95());
	b.append(" kilometrów na benzynie\n");
	b.append(fuelCost.getLpgOn100km());
	b.append(" - spalanie LPG na 100km\n");
	b.append(fuelCost.getPb95On100km());
	b.append(" - spalanie benzyny na 100km\nKoszt podróży wyniesie ");
	b.append(cost);
	b.append(" PLN");
	System.out.println(b.substring(0));

    }

}
