package assignment2.bus.system;

class Person {
    private static int nextTicketNumber;

    private final int TICKET_NUMBER = nextTicketNumber;
    private final String NAME;

    public Person() {
        this.NAME = "NO NAME";
        nextTicketNumber++;
    }

    public Person(String name) {
        this.NAME = name;
        nextTicketNumber++;
    }

    @Override
    public String toString() { return String.format("%d\t%s", this.TICKET_NUMBER, this.NAME); }
}