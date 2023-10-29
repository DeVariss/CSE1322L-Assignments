package assignment3.usps.mail_formats;

public abstract class Box extends Mail {
    private double height = 0d;
    private int count = 0;

    public Box() { super(); }

    public Box(String deliveryAddress, String returnAddress, double width, double length, double height, int count) {
        super(deliveryAddress, returnAddress, width, length);
        this.height = height;
        this.count = count;
    }

    public double getHeight() { return this.height; }
    public int getCount() { return this.count; }

    @Override
    public String toString() {
        return String.format("%s\n%s x %s x %s", super.toString(),
                String.valueOf(super.getWidth()), String.valueOf(super.getLength()), String.valueOf(height));
    }
}