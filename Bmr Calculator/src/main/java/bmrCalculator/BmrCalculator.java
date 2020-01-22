package bmrCalculator;

public class BmrCalculator {
    double bmr;
    double bmi;
    
    public double countBmi(Person person) {
	double height = person.getHeight()/100;
	bmi=person.getWeight()/(height*height);
	bmi = Math.round(bmi * 100) / 100;
	System.out.print(person.getName()+", Twoje BMI (indeks masy ciała) wynosi: " + bmi + ". ");
	if (bmi<18.5) {
	    System.out.println("Masz niedowagę (BMI<18.5)");
	}
	if (18.5<=bmi&bmi<=24.9) {
	    System.out.println("Twoja waga jest prawidłowa (18.5<=BMI<=24.9)");
	}
	if (25<=bmi&bmi<=29.9) {
	    System.out.println("Masz nadwagę (25<=BMI<=29.9)");
	}
	if (bmi>=30) {
	    System.out.println("Tak wysokie BMI oznacza otyłość (BMI>=30)");
	    
	}
	return bmi;
    }
    
   private void countPpmBmr(Person person) {
	
	if (person.getFizGender() == Gender.MALE) {

	    bmr = (9.99 * person.getWeight() + 6.25 * person.getHeight() - 4.92 * person.getAge()) + 5;

	}

	if (person.getFizGender() == Gender.FEMALE) {

	    bmr = (9.99 * person.getWeight() + 6.25 * person.getHeight() - 4.92 * person.getAge()) - 161;

	}

	
	bmr = Math.round(bmr * 100) / 100;
	System.out.println("Twoje PPM/BMR (podstawowa przemiana materii) wynosi: " + bmr+" kcal");
    }

    public double countCpmTmr(Person person) {
	countPpmBmr(person);
	switch (person.getActivity()) {
	case NONE:
	    bmr = bmr * person.getActivity().factor;
	    break;
	case LOW:
	    bmr = bmr * person.getActivity().factor;
	    break;
	case MEDIUM:
	    bmr = bmr * person.getActivity().factor;
	    break;
	case HIGH:
	    bmr = bmr * person.getActivity().factor;
	    break;
	case VERY_HIGH:
	    bmr = bmr * person.getActivity().factor;
	    break;
	default:
	}
	bmr = Math.round(bmr * 100) / 100;
	System.out.println("Twoje CPM/TMR (całkowita przemiana materii) wynosi: " + bmr + " kcal");
	return bmr;
    }
	
    }

