package ru.specialist.person;

public class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person() {
        System.out.println("Create Person");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        System.out.println("createName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void getInfoAboutGuest(Person person) {
        System.out.println("Guest\nName:" + person.getName() + "\nAge:" + person.getAge());
        getGenderGuest();
    }

    public void getGenderGuest() {
        gender.GetGenderGuest();
    }
}
