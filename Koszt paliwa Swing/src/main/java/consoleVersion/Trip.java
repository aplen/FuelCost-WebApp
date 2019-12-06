package consoleVersion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Trip {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	boolean isNotCorrect = true;
	FuelCost cost = new FuelCost();

	do {
	    try {
		System.out.println(
			"Podaj szacowane średnie spalanie benzyny (w litrach/100km) w Twoim samochodzie \nwez pod uwagę charakter trasy, którą chcesz pokonać:");
		cost.pb95On100km = scan.nextDouble();
		System.out.println(
			"Podaj szacowane średnie spalanie LPG (w litrach/100km) w Twoim samochodzie \nwez pod uwagę charakter trasy, którą chcesz pokonać:");
		cost.lpgOn100km = scan.nextDouble();
		System.out.println("Ile kosztuje litr benzyny?");
		cost.pb95Price = scan.nextDouble();
		System.out.println("Ile kosztuje litr LPG?");
		cost.lpgPrice = scan.nextDouble();
		System.out.println("Ile km przejedziesz na LPG?");
		cost.kmOnLPG = scan.nextDouble();
		System.out.println("Ile km przejedziesz na benzynie?");
		cost.kmOnPB95 = scan.nextDouble();

		isNotCorrect = false;
	    } catch (InputMismatchException e) {

		System.out.println("Niepoprawny format danych, wprowadz ponownie\n");
		scan.next();
	    }
	} while (isNotCorrect);
	scan.close();

	System.out.println("Cena LPG za 1 litr: " + cost.lpgPrice + " PLN\n" + "Cena benzyny za 1 litr: "
		+ cost.pb95Price + " PLN\n" + cost.kmOnLPG + " kilometrów na LPG\n" + cost.kmOnPB95
		+ " kilometrów na benzynie\n" + cost.lpgOn100km + " - spalanie LPG na 100km\n" + cost.pb95On100km
		+ " - spalanie benzyny na 100km\n" + "Koszt podróży wyniesie " + cost.calculateCost() + " PLN");

    }

}
