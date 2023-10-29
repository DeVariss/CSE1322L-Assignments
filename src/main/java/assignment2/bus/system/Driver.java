package assignment2.bus.system;

import java.util.Scanner;

public class Driver {
    private static final String COMMANDS = "1. Add bus\n2. Add Person to bus\n3. Remove bus\n4. Remove person\n5. List passengers\n6. List buses\n7. Requeue bus\n8. Transfer person\n9. Dispatch\n10. End terminal\nCommand: ";

    private static Dispatcher dispatcher = new Dispatcher();

    public static void main(String[] args) {
        while (true) {
            String command = getInput(COMMANDS);
            switch (command) {
                case "1" -> cmdAddBus(new Bus());
                case "2" -> cmdAddPerson(Integer.parseInt(getInput("Bus ID: ")));
                case "3" -> cmdRemoveBus(Integer.parseInt(getInput("Bus ID: ")));
                case "4" -> cmdRemovePerson(Integer.parseInt(getInput("Bus ID: ")));
                case "5" -> cmdListPassengers(Integer.parseInt(getInput("Bus ID: ")));
                case "6" -> System.out.println("BUS QUEUE\n" + dispatcher);
                case "7" -> cmdRequeueBus(Integer.parseInt(getInput("Bus ID: ")));
                case "8" -> cmdTransferPerson(Integer.parseInt(getInput("Origin bus ID: ")));
                case "9" -> cmdDispatchBus(dispatcher.dispatchBus());
                case "10" -> { return; }
                default -> System.out.println(command + " is not a command.");
            }
        }
    }

    private static void cmdAddBus(Bus bus) { System.out.printf("%d added to position %d\n", bus.getBusId(), dispatcher.addBus(bus)); }

    private static void cmdAddPerson(int busId) {
        Bus bus = dispatcher.findBus(busId);
        if (bus != null) {
            String name = getInput("Name: ");
            Person person = new Person(name);
            bus.addPerson(person);
            System.out.printf("%s has been added to bus %d\n", name, bus.getBusId());
        } else System.out.println("No bus with id " + busId);
    }

    private static void cmdRemoveBus(int busId) {
        Bus bus = dispatcher.findBus(busId);
        if (bus != null) {
            dispatcher.removeBus(busId);
            System.out.printf("Bus %d removed\n", busId);
        } else System.out.println("No bus with id " + busId);
    }

    private static void cmdRemovePerson(int busId) {
        Bus bus = dispatcher.findBus(busId);
        if (bus != null) {
            String name = getInput("Name: ");
            Person person = bus.findPerson(name);
            System.out.println(bus.removePerson(person) ? String.format("%s has been removed from bus %d\n", name, busId) : "No person found in bus " + busId + "\n");
        } else System.out.println("No bus with ID" + busId);
    }

    private static void cmdListPassengers(int busId) {
        Bus bus = dispatcher.findBus(busId);
        if (bus != null) System.out.println("Bus " + busId + "\n" + bus.getPassengers());
        else System.out.println("No bus with id " + busId);
    }

    private static void cmdRequeueBus(int busId) {
        Bus bus = dispatcher.findBus(busId);
        if (bus != null) {
            int newPos = Integer.parseInt(getInput("New position: "));
            dispatcher.removeBus(busId);
            System.out.printf("Bus %d added to position %d\n", busId, dispatcher.addBus(bus, newPos));
        } else System.out.println("No bus with id " + busId);
    }

    private static void cmdTransferPerson(int busId) {
        Bus bus = dispatcher.findBus(busId);
        if (bus == null) System.out.println("No bus with id " + busId);
        else {
            String name = getInput("Name: ");
            Person person = bus.findPerson(name);
            if (person == null) System.out.println("No person named " + name);
            else {
                int secondBusId = Integer.parseInt(getInput("Transfer bus ID: "));
                Bus secondBus = dispatcher.findBus(secondBusId);
                if (secondBus == null) System.out.println("No bus with id" + secondBusId);
                else System.out.println(Bus.transferPerson(bus, secondBus, person) ? "Person transferred successfully" : "Person transfer failed");
            }
        }
    }

    private static void cmdDispatchBus(Bus bus) { System.out.println(bus == null ? "Bus queue is empty" : "Bus " + bus.getBusId() + " has been dispatched"); }

    private static String getInput(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }
}