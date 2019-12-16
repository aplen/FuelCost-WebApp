package bmrCalculator;

public interface ProfileBuilder {
    
    Person build();
    
    ProfileBuilder setFizGender(final Gender fizGender);
    ProfileBuilder setActivity(final Activity strength);
    ProfileBuilder setName(final String name);
    ProfileBuilder setWeight(final double weight);
    ProfileBuilder setHeight(final double height);
    ProfileBuilder setAge(final int age);
}
