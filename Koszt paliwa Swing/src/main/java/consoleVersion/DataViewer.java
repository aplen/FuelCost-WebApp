package consoleVersion;

public class DataViewer {
/**
 * Łączy pobrane dane i wynik w String oraz wyświetla użytkownikowi
 *  
 * @param trip
 */
     void viewData(Trip trip, double cost){
	
	StringBuilder b = new StringBuilder();
	
	b.append("Cena LPG za 1 litr: ");
	b.append(trip.getLpgPrice());
	b.append(" PLN\nCena benzyny za 1 litr: ");
	b.append(trip.getPb95Price());
	b.append(" PLN\n");
	b.append(trip.getKmOnLPG());
	b.append(" kilometrów na LPG\n");
	b.append(trip.getKmOnPB95());
	b.append(" kilometrów na benzynie\n");
	b.append(trip.getLpgOn100km());
	b.append(" - spalanie LPG na 100km\n");
	b.append(trip.getPb95On100km());
	b.append(" - spalanie benzyny na 100km\nKoszt podróży wyniesie ");
	b.append(cost);
	b.append(" PLN");
	System.out.println(b.substring(0));
    }
}
