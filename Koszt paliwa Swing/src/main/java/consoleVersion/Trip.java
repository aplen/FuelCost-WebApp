package consoleVersion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Trip {
	private double spalanieNa100kmLPG;
	public double getspalanieNa100kmLPG() {
		return spalanieNa100kmLPG;
	}
	private double spalanieNa100kmPB95;
	public double getspalanieNa100kmPB95() {
		return spalanieNa100kmPB95;
	}
	private double cenaLPG;
	public double getcenaLPG() {
		return cenaLPG;
	}
	private double cenaPB95;
	public double getcenaPB95() {
		return cenaPB95;
	}
	private double kmNaLPG;
	public double getkmNaLPG() {
		return kmNaLPG;
	}
	private double kmNaPB95;
	public double getkmNaPB95() {
		return kmNaPB95;
	}

	Trip() {
		Scanner scan = new Scanner(System.in); //uzytkownik przypisuje zmiennym wartoœci wprowadzaj¹c je w konsoli
		boolean isNotCorrect = true;

		do {
			try {
				System.out.println(
						"Podaj szacowane œrednie spalanie benzyny (w litrach/100km) w Twoim samochodzie \nwez pod uwagê charakter trasy, któr¹ chcesz pokonaæ:");
				spalanieNa100kmPB95 = scan.nextDouble();
				System.out.println(
						"Podaj szacowane œrednie spalanie LPG (w litrach/100km) w Twoim samochodzie \nwez pod uwagê charakter trasy, któr¹ chcesz pokonaæ:");
				spalanieNa100kmLPG = scan.nextDouble();
				System.out.println("Ile kosztuje litr benzyny?");
				cenaPB95 = scan.nextDouble();
				System.out.println("Ile kosztuje litr LPG?");
				cenaLPG = scan.nextDouble();
				System.out.println("Ile km przejedziesz na LPG?");
				kmNaLPG = scan.nextDouble();
				System.out.println("Ile km przejedziesz na benzynie?");
				kmNaPB95 = scan.nextDouble();

				isNotCorrect = false;
			} catch (InputMismatchException moje) {

				moje.printStackTrace();
				System.err.println("Niepoprawny format danych, wprowadz dane ponownie");
				scan.nextLine();
			}
		} while (isNotCorrect);
		scan.close();
		
	}
	public static void main(String[] args) {
		Trip myTrip = new Trip();
		System.out.println("Cena LPG za 1 litr: " + myTrip.getcenaLPG() + " PLN");
		System.out.println("Cena benzyny za 1 litr: " + myTrip.getcenaPB95() + " PLN");
		System.out.println(myTrip.getkmNaLPG() + " kilometrów na LPG");
		System.out.println(myTrip.getkmNaPB95() + " kilometrów na benzynie");
		System.out.println(myTrip.getspalanieNa100kmLPG() + " - spalanie LPG na 100km");
		System.out.println(myTrip.getspalanieNa100kmPB95() + " - spalanie benzyny na 100km");
		System.out.println("Koszt podró¿y wyniesie " + myTrip.fuelCost() + " PLN");
	}
	double fuelCost() {
		double fuelCost = (Math.round((spalanieNa100kmLPG * cenaLPG * kmNaLPG / 100 + spalanieNa100kmPB95 * cenaPB95 * kmNaPB95 / 100)* 1000.0))/1000.0;
		return fuelCost;
	}
	
}
