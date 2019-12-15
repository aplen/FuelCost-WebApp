package bmrCalculator;

public enum Activity {
    NONE(1.2, "brak aktywnosci, praca siedzaca"),
    LOW(1.4, "niska aktywnosc (praca siedzaca i 1-2 treningi w tygodniu)"),
    MEDIUM(1.6, "srednia aktywnosc (praca siedzaca i treningi 3-4 razy w tygodniu)"),
    HIGH(1.8, "wysoka aktywnosc (praca fizyczna i 3-4 treningi w tygodniu)"),
    VERY_HIGH(2.0, "bardzo wysoka aktywnosc (zawodowi sportowcy, osoby codziennie trenujace)");

    String describe;
    double factor;

    Activity(double factor, String describe) {
	this.describe = describe;
	this.factor=factor;
    }
    
    public String toString() {
   	return describe;
       }

}
