package assignment2.bus.system;

import java.util.ArrayList;

class Bus {
    private static int nextId;

    ArrayList<Person> passengers = new ArrayList<>();
    private final int BUS_ID = nextId;

    public Bus() { nextId++; }

    public int getBusId() { return this.BUS_ID; }

    public void addPerson(Person passenger) { this.passengers.add(passenger); }

    public boolean removePerson(Person passenger) { return this.passengers.remove(passenger); }

    public Person findPerson(String name) {
        for (Person passenger : this.passengers) {
            String passengerName = passenger.toString().substring(passenger.toString().lastIndexOf("\t") + 1);
            if (passengerName.equals(name))
                return passenger;
        }
        return null;
    }

    public static boolean transferPerson(Bus bus1, Bus bus2, Person passenger) {
        if (bus1.passengers.contains(passenger)) {
            bus1.removePerson(passenger);
            bus2.addPerson(passenger);
        }
        return !bus1.passengers.contains(passenger);
    }

    public String getPassengers() {
        String str = "";
        for (Person passenger : this.passengers) str += passenger.toString() + "\n";
        return str;
    }

    @Override
    public String toString() { return String.valueOf(this.BUS_ID); }
}