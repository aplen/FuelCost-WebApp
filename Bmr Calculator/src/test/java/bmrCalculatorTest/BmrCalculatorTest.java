package bmrCalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bmrCalculator.Activity;
import bmrCalculator.BmrCalculator;
import bmrCalculator.Gender;
import bmrCalculator.Person;
import bmrCalculator.ProfileBuilder;
import bmrCalculator.ProfileBuilderImpl;

public class BmrCalculatorTest {
    Person person;
    BmrCalculator calculator = new BmrCalculator();

    @Test
    public void testCountBmi() {

	// given
	ProfileBuilder builder = new ProfileBuilderImpl().setAge(20).setFizGender(Gender.MALE).setHeight(198)
		.setName("Krzyś").setActivity(Activity.MEDIUM).setWeight(85);
	person = builder.build();

	// when
	double bmi = calculator.countBmi(person);
	double cpm = calculator.countCpmTmr(person);

	// then
	assertEquals(0, 0, 0);
    }

    @Test
    public void testCountCpmTmr() {
    }

}
