package assignment3.usps.mail_types;

import assignment3.usps.mail_formats.Box;

public class RegularBox extends Box {
    private String items = "";
    private double weight = 0d;

    public RegularBox() { super(); }

    public RegularBox(String deliveryAddress, String returnAddress, double width,
                      double length, double height, int count, String items, double weight) {
        super(deliveryAddress, returnAddress, width, length, height, count);
        this.items = items;
        this.weight = weight;
    }

    public String getItems() { return this.items; }
    public double getWeight() { return this.weight; }

    @Override
    public String toString() { return String.format("%s\nItems: %s\nWeight: %s", super.toString(), this.items, String.valueOf(this.weight)); }
}