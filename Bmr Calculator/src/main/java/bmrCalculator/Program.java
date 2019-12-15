package bmrCalculator;

public class Program {

    public static void main(String[] args) {

	ProfileBuilder builder = new ProfileBuilderImpl();

	builder.setAge(35);
	builder.setFizGender(Gender.MAN);
	builder.setHeight(174);
	builder.setName("Adam");
	builder.setActivity(Activity.NONE);
	builder.setWeight(75);
	Profile myPerson = builder.build();

	System.out.println(myPerson);
	BmrCalculator calc = new BmrCalculator();
	calc.bmrCounter(myPerson);
    }

}
