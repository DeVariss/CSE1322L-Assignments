package assignment1;

import java.util.Scanner;


public final class driver {
    private driver(){}


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OrderList restaurantOrders = new OrderList();

        while (true) {
            System.out.print("1- Create order\n2- Delete order\n3- Ready order\n4- Print order\n5- Print all orders\n6- Exit\nCommand: ");
            int command = Integer.parseInt(in.nextLine());
            System.out.println();
            switch (command) {
                case 1 :
                    String[] items = new String[3];
                    for (int i = 0; i < items.length; i++) {
                        System.out.print("Item: ");
                        items[i] = in.nextLine();
                    }
                    Order order = new Order(items);
                    restaurantOrders.addOrder(order);
                    System.out.println("Order has been added.");
                    System.out.println();
                    break;
                case 2 :
                    System.out.print("Order ID: ");
                    restaurantOrders.removeOrder(Integer.parseInt(in.nextLine()));
                    System.out.println("Order has been removed.");
                    System.out.println();
                    break;
                case 3 :
                    System.out.print("Order ID: ");
                    restaurantOrders.readyOrder(Integer.parseInt(in.nextLine()));
                    System.out.println("Order has been set to \"Ready\"");
                    System.out.println();
                    break;
                case 4 :
                    System.out.print("Order ID: ");
                    String str = restaurantOrders.printOrder(Integer.parseInt(in.nextLine()));
                    System.out.println();
                    System.out.println(str.equals("") ? "No order with such id" : str);
                    System.out.println();
                    break;
                case 5 :
                    System.out.println(restaurantOrders.printOrders());
                    System.out.println();
            }
            if (command == 6) { break; }
        }
    }
}