package consoleVersion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    /**
     * ustawia i waliduje wartości pól klasy Trip danymi pobranymi od użytkownika za
     * pomocą klasy Scanner
     */

    void retrieveDataTo(Trip trip) {
	Scanner scan = new Scanner(System.in);
	boolean isNotCorrect = true;
/*
 * pobieranie danych od użytkownika w pętli, która wykonuje się dopóki wszystkie pola nie zostaną wypełnione poprawnymi wartościami
 * dane są przekazywane do klasy Trip
 * 
 */
	do {
	    try {
		
		System.out.print("Podaj szacowane średnie spalanie benzyny (w litrach/100km) w Twoim samochodzie \n"
			+ "wez pod uwagę charakter trasy, którą chcesz pokonać:");
		
		trip.setPb95On100km(scan.nextDouble());
		System.out.print("Podaj szacowane średnie spalanie LPG (w litrach/100km) w Twoim samochodzie \n"
			+ "wez pod uwagę charakter trasy, którą chcesz pokonać:");
		trip.setLpgOn100km(scan.nextDouble());
		System.out.print("Ile kosztuje litr benzyny?");
		trip.setPb95Price(scan.nextDouble());
		System.out.print("Ile kosztuje litr LPG?");
		trip.setLpgPrice(scan.nextDouble());
		System.out.print("Ile km przejedziesz na LPG?");
		trip.setKmOnLPG(scan.nextDouble());
		System.out.print("Ile km przejedziesz na benzynie?");
		trip.setKmOnPB95(scan.nextDouble());

		isNotCorrect = false;
	    } catch (InputMismatchException | IllegalArgumentException e1) {
		System.out.println("Niepoprawny format danych, wprowadz ponownie");
	    }
	} while (isNotCorrect);
    }
}
