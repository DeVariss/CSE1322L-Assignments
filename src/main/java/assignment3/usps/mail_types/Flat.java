package assignment3.usps.mail_types;

import usps.mail_formats.Envelope;

public class Flat extends Envelope {
    private String contents = "";

    public Flat() { super(); }

    public Flat(String deliveryAddress, String returnAddress, double width, double length, double thickness, String contents) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.contents = contents;
    }

    public String getContents() { return this.contents; }
}