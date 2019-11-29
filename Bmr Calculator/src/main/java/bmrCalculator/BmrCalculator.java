package bmrCalculator;
enum Activity{
	NONE(1.2,"brak aktywnoœci, praca siedz¹ca"),
	LOW(1.4,"niska aktywnoœæ (praca siedz¹ca i 1-2 treningi w tygodniu)"),
	MEDIUM(1.6,"œrednia aktywnoœæ (praca siedz¹ca i treningi 3-4 razy w tygodniu)"),
	HIGH(1.8,"wysoka aktywnoœæ (praca fizyczna i 3-4 treningi w tygodniu)"),
	VERY_HIGH(2.0, "bardzo wysoka aktywnoœæ (zawodowi sportowcy, osoby codziennie trenuj¹ce)");
	
	double factor;
	String describe;
	
	
	Activity(double factor, String describe){
		this.factor = factor;
		this.describe = describe;
	}
	public String toString() {return describe;}
}


enum Gender {
    MAN,
    WOMAN;
        }

public class BmrCalculator {
	
	Gender fizGender;
	Activity strength;
	String name;
	double weight;
	double height;
	int age;
	double bmr;
	
	

	BmrCalculator(Gender fizGender, String name, double weight, double height, int age, Activity strength) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.name = name;
		this.fizGender=fizGender;
		this.strength=strength;
		this.bmrCounter();
		System.out.println(this);
	}

	void bmrCounter() {

		if (fizGender==Gender.MAN) {

			bmr = (9.99 * weight + 6.25 * height - 4.92 * age) + 5;

		}

		if (fizGender==Gender.WOMAN) {

			bmr = (9.99 * weight + 6.25 * height - 4.92 * age) - 161;

		}
		
		switch(this.strength) {
		case NONE:
			bmr=bmr*1.2;
			break;
		case LOW:
			bmr=bmr*1.4;
			break;
		case MEDIUM:
			bmr=bmr*1.6;
			break;
		case HIGH:
			bmr=bmr*1.8;
			break;
		case VERY_HIGH:
			bmr=bmr*2.0;
			break;
		}

	}

	public String toString() {
		if (fizGender==Gender.MAN) 
		return name + ", wybra³eœ aktywnoœæ: "+ strength + ", \nTwoje BMR wynosi: " + bmr;
		else return name + ", wybra³aœ aktywnoœæ: "+ strength + ", \nTwoje BMR wynosi: " + bmr;
	}

	
}
