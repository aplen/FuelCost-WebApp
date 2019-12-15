package bmrCalculator;

public class ProfileBuilderImpl implements ProfileBuilder {

    private Profile person;

    ProfileBuilderImpl() {
   	person = new Profile(); //powstanie nowy obiekt bez argumentow
       }

    @Override
    public String toString() {
	return "ProfileBuilderImpl [person=" + person + "]";
    }

    @Override
    public Profile build() {//ta metoda pozwoli wydobyc nasz obiekt z przypisanymi argumentami z buildera
	return person;
    }
/*
 * metody typu interfejsu zmieniaja settery klasy Person
 */


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
