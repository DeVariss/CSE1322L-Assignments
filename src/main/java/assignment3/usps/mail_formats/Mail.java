package assignment3.usps.mail_formats;

public abstract class Mail {
    private static int nextId = 0;

    private final int ID = nextId;

    private String deliveryAddress = "";
    private String returnAddress = "";
    private double width = 0d;
    private double length = 0d;

    public Mail() { nextId++; }

    public Mail(String deliveryAddress, String returnAddress, double width, double length) {
        this();
        this.deliveryAddress = deliveryAddress;
        this.returnAddress = returnAddress;
        this.width = width;
        this.length = length;
    }

    public String getDeliveryAddress() { return this.deliveryAddress; }
    public String getReturnAddress() { return this.returnAddress; }
    public double getWidth() { return this.width; }
    public double getLength() { return this.length; }

    @Override
    public String toString() { return String.format("%d\n%s\n%s", this.ID, this.deliveryAddress, this.returnAddress); }
}