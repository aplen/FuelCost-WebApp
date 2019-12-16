package bmrCalculator;

public class Program {

    public static void main(String[] args) {

	ProfileBuilder builder = new ProfileBuilderImpl();

	builder.setAge(32);
	builder.setFizGender(Gender.FEMALE);
	builder.setHeight(168);
	builder.setName("Kasia");
	builder.setActivity(Activity.LOW);
	builder.setWeight(90);
	
	Person person = builder.build();
	System.out.println(person);
	BmrCalculator calculator = new BmrCalculator();
	calculator.countBMI(person);
	calculator.countCPM_TMR(person);
    }

}
