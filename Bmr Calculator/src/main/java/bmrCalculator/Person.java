package bmrCalculator;

public class Person {
    
   
    private Gender fizGender;
    private Activity activity;
    private String name;
    private double weight;
    private double height;
    private int age;
    
    public void setFizGender(Gender fizGender) {
        this.fizGender = fizGender;
    }
    public void setActivity(Activity strength) {
        this.activity = strength;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getFizGender() {
        return fizGender;
    }
    public Activity getActivity() {
        return activity;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
	String choose="";
	if (fizGender == Gender.MALE)
	    choose=", wprowadziłeś";
	if (fizGender == Gender.FEMALE)
	    choose=", wprowadziłaś";
	return "Witaj " + name + choose +" dane:\nPłeć= " + fizGender + ", aktywność= " + activity + ", \nwaga= " + weight
		+ "kg, wzrost= " + height + "cm, wiek= " + age + " lat.\n";
    }
}