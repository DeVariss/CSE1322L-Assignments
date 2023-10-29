package assignment3.usps.mail_formats;

public abstract class Envelope extends Mail {
    private double thickness = 0d;

    public Envelope() { super(); }

    public Envelope(String deliveryAddress, String returnAddress, double width, double length, double thickness) {
        super(deliveryAddress, returnAddress, width, length);
        this.thickness = thickness;
    }

    public double getThickness() { return this.thickness; }

    @Override
    public String toString() {
        return String.format("%s\n%s x %s x %s", super.toString(), String.valueOf(super.getWidth()),  String.valueOf(super.getLength()), String.valueOf(this.thickness)); }
}