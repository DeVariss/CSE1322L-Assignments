package assignment1;

public final class OrderList {
    private Order[] orderList;

    public OrderList() { orderList = new Order[0]; }


    public void addOrder(Order order) {
        if (this.orderList.length == 0) { this.orderList = new Order[1]; }
        boolean found = false;
        for (int i = 0; i < this.orderList.length; i++) {
            if (this.orderList[i] == null) {
                found = true;
                this.orderList[i] = order;
                break;
            }
        }
        if (!found) {
            Order[] newList = new Order[this.orderList.length * 2];
            for (int i = 0; i < this.orderList.length; i++) { newList[i] = this.orderList[i]; }
            newList[this.orderList.length] = order;
            this.orderList = newList;
        }
    }


    public void removeOrder(int id) {
        if (this.orderList.length > 0) {
            for (int i = 0; i < this.orderList.length; i++) {
                if (this.orderList[i] != null) {
                    if (this.orderList[i].getId() == id) {
                        this.orderList[i] = null;
                        break;
                    }
                }
            }
        }
    }


    public void readyOrder(int id) {
        if (this.orderList.length > 0) {
            for (int i = 0; i < this.orderList.length; i++) {
                if (this.orderList[i] != null) {
                    if (this.orderList[i].getId() == id) {
                        this.orderList[i].ready = true;
                        break;
                    }
                }
            }
        }
    }


    // optimized version of bubble list, source: https://www.geeksforgeeks.org/bubble-sort/
    private void sortOrders() {
        for (int i = 0; i < this.orderList.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < this.orderList.length - i - 1; j++) {
                if (this.orderList[j] == null) {
                    swapped = true;
                    Order temp = this.orderList[j];
                    this.orderList[j] = this.orderList[j + 1];
                    this.orderList[j + 1] = temp;
                } else if (this.orderList[j + 1] == null) {
                    continue;
                } else if (this.orderList[j].getId() > this.orderList[j + 1].getId()) {
                    Order temp = this.orderList[j];
                    this.orderList[j] = this.orderList[j + 1];
                    this.orderList[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) { break; }
        }
    }


    public String printOrder(int id) {
        String str = "";
        if (this.orderList.length == 0) { return str; }
        for (int i = 0; i < this.orderList.length; i++){
            if (this.orderList[i].getId() == id) {
                str = this.orderList[i].toString();
                break;
            }
        }
        return str;
    }


    public String printOrders() {
        String str = "";
        if (this.orderList.length == 0) { return str; }
        sortOrders();
        if (this.orderList[0] == null) { return str; }
        boolean hasReadyOrder = false;
        for (Order element : this.orderList) {
            if (element == null) { continue; }
            else if (element.ready) {
                hasReadyOrder = true;
                break;
            }
        }
        if (!hasReadyOrder) {
            str += "Preparing";
            for (Order element : this.orderList) {
                if (element == null) { break; }
                str += "\n" + element.getId();
            }
        } else {
            str += "Ready";
            for (Order element : this.orderList) {
                if (element == null) { break; }
                else if (element.ready) { str += "\n" + element.getId(); }
            }
            str += "\n" + "Preparing";
            for (Order element : this.orderList) {
                if (element == null) { break; }
                else if (!element.ready) { str += "\n" + element.getId(); }
            }
        }
        return str;
    }
}