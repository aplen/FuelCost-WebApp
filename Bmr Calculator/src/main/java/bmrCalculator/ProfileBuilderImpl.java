package bmrCalculator;

public class ProfileBuilderImpl implements ProfileBuilder {

    private Person person;

    public ProfileBuilderImpl() {
   	person = new Person();
       }

    @Override
    public String toString() {
	return "ProfileBuilderImpl [person=" + person + "]";
    }

    @Override
    public Person build() {
	return person;
    }


    @Override
    public ProfileBuilder setFizGender(Gender fizGender) {
	person.setFizGender(fizGender);
	return this;
    }

    @Override
    public ProfileBuilder setActivity(Activity activity) {
	person.setActivity(activity);
	return this;
    }

    @Override
    public ProfileBuilder setName(String name) {
	person.setName(name);
	return this;
    }

    @Override
    public ProfileBuilder setWeight(double weight) {
	person.setWeight(weight);
	return this;
    }

    @Override
    public ProfileBuilder setHeight(double height) {
	person.setHeight(height);
	return this;
    }

    @Override
    public ProfileBuilder setAge(int age) {
	person.setAge(age);
	return this;
    }
}
