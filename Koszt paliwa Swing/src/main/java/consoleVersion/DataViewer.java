package consoleVersion;

public class DataViewer {

     void viewData(FuelCost fc){
	
	StringBuilder b = new StringBuilder();
	
	b.append("Cena LPG za 1 litr: ");
	b.append(fc.getLpgPrice());
	b.append(" PLN\nCena benzyny za 1 litr: ");
	b.append(fc.getPb95Price());
	b.append(" PLN\n");
	b.append(fc.getKmOnLPG());
	b.append(" kilometrów na LPG\n");
	b.append(fc.getKmOnPB95());
	b.append(" kilometrów na benzynie\n");
	b.append(fc.getLpgOn100km());
	b.append(" - spalanie LPG na 100km\n");
	b.append(fc.getPb95On100km());
	b.append(" - spalanie benzyny na 100km\nKoszt podróży wyniesie ");
	b.append(fc.getCost());
	b.append(" PLN");
	System.out.println(b.substring(0));
    }
}
