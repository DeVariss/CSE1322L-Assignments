package assignment3.usps.command_prompt;

import java.util.ArrayList;
import java.util.Scanner;

import assignment3.usps.mail_types.Flat;
import assignment3.usps.mail_types.Letter;
import assignment3.usps.mail_types.RegularBox;
import assignment3.usps.mail_types.LiveBox;

import assignment3.usps.mail_formats.Mail;

public final class UspsDriver {
    private UspsDriver(){}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Mail> deliver = new ArrayList<>();
        UserInput promptUser = (msg) -> {
            System.out.print(msg);
            return in.nextLine();
        };
        while (true) {
            boolean isEnded = false;
            int command = Integer.parseInt(takeInput
                    (promptUser, "1. Mail a letter\n2. Mail a flat\n3. Send a package\n4. Send a live package\n5. Deliver mail\n6. Exit\nCommand #: "));
            if (command >= 1 && command <= 4) {
                String deliveryAddress = takeInput(promptUser, "Delivery Address: ");
                String returnAddress = takeInput(promptUser, "Return Address: ");
                double length = Double.parseDouble(takeInput(promptUser, "Length: "));
                double width = Double.parseDouble(takeInput(promptUser, "Width: "));
                boolean isValid = false;
                switch (command) {
                    case 1 -> {
                        double thickness = Double.parseDouble(takeInput(promptUser, "Thickness: "));
                        String body = takeInput(promptUser, "Body: ");
                        isValid = HandleMail.letter
                                (new Letter(deliveryAddress, returnAddress, width, length, thickness, body), deliver);
                    }
                    case 2 -> {
                        double thickness = Double.parseDouble(takeInput(promptUser, "Thickness: "));
                        String contents = takeInput(promptUser, "Contents: ");
                        isValid = HandleMail.flat
                                (new Flat(deliveryAddress, returnAddress, width, length, thickness, contents), deliver);
                    }
                    case 3 -> {
                        double height = Double.parseDouble(takeInput(promptUser, "Height: "));
                        double weight = Double.parseDouble(takeInput(promptUser, "Weight: "));
                        String items = takeInput(promptUser, "Items: ");
                        int count = Integer.parseInt(takeInput(promptUser, "Count: "));
                        isValid = HandleMail.regularBox
                                (new RegularBox(deliveryAddress, returnAddress, width, length, height, count, items, weight), deliver);
                    }
                    case 4 -> {
                        double height = Double.parseDouble(takeInput(promptUser, "Height: "));
                        int count = Integer.parseInt(takeInput(promptUser, "Count: "));
                        String animal = takeInput(promptUser, "Animal: ");
                        int age = Integer.parseInt(takeInput(promptUser, "Age: "));
                        isValid = HandleMail.liveBox
                                (new LiveBox(deliveryAddress, returnAddress, width, length, height, count, animal, age), deliver);
                    }
                }
                System.out.println((isValid) ? "Mail is valid and has been added.\n" : "Mail is not valid and wasn't added.\n");
            } else {
                switch (command) {
                    case 5 -> {
                        ArrayList<String> message = new ArrayList<>();
                        message.add("DISPATCHING THE FOLLOWING ITEMS FOR DELIVERY:");
                        deliver.forEach((mail) -> message.add(mail.toString()));
                        message.forEach(System.out::println);
                        deliver.clear();
                    }
                    case 6 -> {
                        isEnded = true;
                        in.reset();
                    }
                    default -> System.out.printf("%d is not a command.\n\n", command);
                }
            }
            if (isEnded) {
                break;
            }
        }
    }

    private static String takeInput(UserInput func, String msg) { return func.prompt(msg); }
}