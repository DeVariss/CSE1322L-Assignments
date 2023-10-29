package assignment3.usps.mail_types;

import usps.mail_formats.Envelope;

public class Letter extends Envelope {
    private String letterBody = "";

    public Letter() { super(); }

    public Letter(String deliveryAddress, String returnAddress, double width, double length, double thickness, String letterBody) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.letterBody = letterBody;
    }

    public String getLetterBody() { return this.letterBody; }
}