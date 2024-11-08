package Inheritance.animals;

public class Animal {
    private  String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setGender(gender);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw  new IllegalArgumentException("Invalid Input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
            if (age<0){
                throw  new IllegalArgumentException("Invalid Input!");
            }
        this.age = age;
    }

    public void setGender(String gender) {
            if (gender==null || gender.trim().isEmpty()){
                throw  new IllegalArgumentException("Invalid Input!");
            }
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s",name,age,gender);
    }
}
