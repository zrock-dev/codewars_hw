package lombok_builder;

public class People{
    private int age;
    private String name;
    private String lastName;
    private String GREET = "hello";

    public People(int age, String name, String lastName) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    protected String greet(){
        return GREET + " my name is " + name;
    }

    public static void main(String[] args) {
        People people = new People(21, "Joshua", "Allphin");
        System.out.println(people.greet());
    }
}
