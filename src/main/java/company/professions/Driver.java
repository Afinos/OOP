package company.professions;

import OOP.Person;

public class Driver extends Person {

    private int experience;

    public Driver(String fullName, int age, int experience) {
        super(fullName, age);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Полное имя водителя: " + getFullName() + "\nВозраст водителя: " + getAge() + "\nОпыт вождения: " + getExperience();
    }
}
