package assignment1;

public final class Order {
    private final int ID;
    private static int nextId = 1;
    public boolean ready;
    public String[] items;

    public Order() {
        this.ID = nextId;
        nextId++;
        this.ready = false;
        this.items = new String[3];
    }
    public Order(String[] items) {
        this.ID = nextId;
        nextId++;
        this.ready = false;
        this.items = items;
    }


    public int getId() { return this.ID; }


    @Override
    public String toString() {
        String str = "Order number: " + this.ID + "\n" + (this.ready ? "Ready" : "Not Ready");
        for (String item : this.items) { str += "\n" + item; }
        return str;
    }
}