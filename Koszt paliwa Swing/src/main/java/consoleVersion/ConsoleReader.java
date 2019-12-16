package consoleVersion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    /**
     * ustawia i waliduje wartości pól klasy FuelCost danymi pobranymi od użytkownika za pomocą klasy Scanner
     */

    void retrieveData(FuelCost fc) {
	Scanner scan = new Scanner(System.in);
	boolean isNotCorrect = true;
/*
 * pobieranie danych od użytkownika w pętli, która wykonuje się dopóki wszystkie pola nie zostaną wypełnione poprawnymi wartościami
 * 
 */
	do {
	    try {
		System.out.print("Podaj szacowane średnie spalanie benzyny (w litrach/100km) w Twoim samochodzie \n"
			+ "wez pod uwagę charakter trasy, którą chcesz pokonać:");
		fc.setPb95On100km(scan.nextDouble());
		System.out.print("Podaj szacowane średnie spalanie LPG (w litrach/100km) w Twoim samochodzie \n"
			+ "wez pod uwagę charakter trasy, którą chcesz pokonać:");
		fc.setLpgOn100km(scan.nextDouble());
		System.out.print("Ile kosztuje litr benzyny?");
		fc.setPb95Price(scan.nextDouble());
		System.out.print("Ile kosztuje litr LPG?");
		fc.setLpgPrice(scan.nextDouble());
		System.out.print("Ile km przejedziesz na LPG?");
		fc.setKmOnLPG(scan.nextDouble());
		System.out.print("Ile km przejedziesz na benzynie?");
		fc.setKmOnPB95(scan.nextDouble());

		isNotCorrect = false;
	    } catch (InputMismatchException e) {

		System.out.println("Niepoprawny format danych, wprowadz ponownie\n");
		scan.next();
	    }
	} while (isNotCorrect);

	scan.close();


    }

}
