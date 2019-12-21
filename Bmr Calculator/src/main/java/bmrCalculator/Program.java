package bmrCalculator;

public class Program {

    public static void main(String[] args) {

	ProfileBuilder builder = new ProfileBuilderImpl();

	builder.setAge(32);
	builder.setFizGender(Gender.MALE);
	builder.setHeight(175);
	builder.setName("Adam");
	builder.setActivity(Activity.LOW);
	builder.setWeight(75);
	
	Person person = builder.build();
	System.out.println(person);
	BmrCalculator calculator = new BmrCalculator();
	calculator.countBmi(person);
	calculator.countCpmTmr(person);
    }

}
