package assignment2.bus.system;

import java.util.ArrayList;

class Dispatcher {
    ArrayList<Bus> busQueue = new ArrayList<>();

    public int addBus(Bus bus) {
        this.busQueue.add(bus);
        return this.busQueue.size() - 1;
    }

    public int addBus(Bus bus, int position) {
        if (position > this.busQueue.size() - 1) {
            this.busQueue.add(bus);
            return this.busQueue.size() - 1;
        } else {
            this.busQueue.add(position, bus);
            return position;
        }
    }

    public Bus findBus(int id) {
        for (Bus bus : this.busQueue)
            if (bus.getBusId() == id) return bus;
        return null;
    }

    public Bus removeBus(int id) {
        Bus returnBus = null;
        for (Bus bus : this.busQueue)
            if (bus.getBusId() == id) {
                returnBus = bus;
                busQueue.remove(bus);
                break;
            }
        return returnBus;
    }

    public Bus dispatchBus() {
        if (busQueue.isEmpty())
            return null;
        else {
            Bus bus = busQueue.get(0);
            busQueue.remove(0);
            return bus;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Bus bus : busQueue) str += bus + "\n";
        return str;
    }
}