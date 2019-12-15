package bmrCalculator;

public class BmrCalculator {

    void bmrCounter(Profile person) {
	double bmr = 0;
	if (person.getFizGender() == Gender.MAN) {

	    bmr = (9.99 * person.getWeight() + 6.25 * person.getHeight() - 4.92 * person.getAge()) + 5;

	}

	if (person.getFizGender() == Gender.WOMAN) {

	    bmr = (9.99 * person.getWeight() + 6.25 * person.getHeight() - 4.92 * person.getAge()) - 161;

	}

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
	System.out.println("Twoje CPM wynosi: " + bmr);
    }

}
