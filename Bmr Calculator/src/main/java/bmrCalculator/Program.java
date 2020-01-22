package bmrCalculator;

public class Program {

    public static void main(String[] args) {

	ProfileBuilder builder = new ProfileBuilderImpl().setAge(20).setFizGender(Gender.MALE).setHeight(198)
		.setName("Krzyś").setActivity(Activity.MEDIUM).setWeight(85);

	Person person = builder.build();
	System.out.println(person);
	BmrCalculator calculator = new BmrCalculator();
	calculator.countBmi(person);
	calculator.countCpmTmr(person);
    }

}
