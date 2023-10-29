package assignment3.usps.mail_types;

import assignment3.usps.mail_formats.Box;

public class LiveBox extends Box {
    private String animal = "";
    private int age = 0;

    public LiveBox() { super(); }

    public LiveBox(String deliveryAddress, String returnAddress, double width, double length, double height, int count, String animal, int age) {
        super(deliveryAddress, returnAddress, width, length, height, count);
        this.animal = animal;
        this.age = age;
    }

    public String getAnimal() { return this.animal; }
    public int getAge() { return this.age; }

    @Override
    public String toString() { return String.format("%s\nAnimal: %s\nCount: %d\nAge (Days): %d", super.toString(), this.animal, super.getCount(), this.age); }
}