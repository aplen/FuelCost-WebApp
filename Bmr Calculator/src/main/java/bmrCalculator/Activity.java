package bmrCalculator;

public enum Activity {
    NONE(1.2, "brak aktywności, praca siedząca"),
    LOW(1.4, "niska aktywność (praca siedząca i 1-2 treningi w tygodniu)"),
    MEDIUM(1.6, "średnia aktywność (praca siedząca i treningi 3-4 razy w tygodniu)"),
    HIGH(1.8, "wysoka aktywność (praca fizyczna i 3-4 treningi w tygodniu)"),
    VERY_HIGH(2.0, "bardzo wysoka aktywność (zawodowi sportowcy, osoby codziennie trenujące)");

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
