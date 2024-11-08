package Encapsulation.ValidationData;


public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be les than 460 leva");
        }

        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.setSalary(salary);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", firstName, lastName, salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary(double percentage) {
        if (this.age > 30) {
            this.salary = salary + salary * percentage / 100;
        } else {
            this.salary = salary + salary * percentage / 200;
        }
    }
}
