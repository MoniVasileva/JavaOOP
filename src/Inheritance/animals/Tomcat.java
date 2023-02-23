package Inheritance.animals;

public class Tomcat extends Cat{
    public Tomcat(String name, int age) {
        super(name, age,"Female");
    }
    @Override
    public String produceSound(){
       return "MEOW";
    }
}
