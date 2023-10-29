package assignment3.usps.command_prompt;

import assignment3.usps.mail_types.Flat;
import assignment3.usps.mail_types.Letter;
import assignment3.usps.mail_types.LiveBox;
import assignment3.usps.mail_types.RegularBox;
import assignment3.usps.mail_formats.Mail;

import java.util.ArrayList;

class HandleMail {
    public static boolean liveBox(LiveBox liveBox, ArrayList<Mail> deliver) {
        boolean hasDelivery = (!liveBox.getDeliveryAddress().isEmpty());
        boolean hasReturn = (!liveBox.getReturnAddress().isEmpty());
        boolean isLength = (liveBox.getLength() >= 6d) && (liveBox.getLength() <= 27d);
        boolean isWidth = (liveBox.getWidth() >= 0.25d) && (liveBox.getWidth() <= 17d);
        boolean isHeight = (liveBox.getHeight() >= 3d) && (liveBox.getHeight() <= 17d);
        boolean hasBees = (liveBox.getAnimal().equals("HONEYBEES")) && (liveBox.getCount() >= 0)
                && (liveBox.getCount() <= 20);
        boolean hasChickens = (liveBox.getAnimal().equals("CHICKEN")) && (liveBox.getCount() >= 0)
                && (liveBox.getCount() <= 10) && (liveBox.getAge() >= 0) && (liveBox.getAge() <= 1);
        if (hasDelivery && hasReturn && isLength && isWidth && isHeight && (hasBees || hasChickens)) {
            deliver.add(liveBox);
            return true;
        } else { return false; }
    }

    public static boolean regularBox(RegularBox regularBox, ArrayList<Mail> deliver) {
        boolean hasDelivery = (!regularBox.getDeliveryAddress().isEmpty());
        boolean hasReturn = (!regularBox.getReturnAddress().isEmpty());
        boolean isLength = (regularBox.getLength() >= 6d) && (regularBox.getLength() <= 27d);
        boolean isWidth = (regularBox.getWidth() >= 0.25d) && (regularBox.getLength() <= 17d);
        boolean isHeight = (regularBox.getHeight() >= 3d) && (regularBox.getHeight() <= 17d);
        boolean isWeight = (regularBox.getWeight() >= 0d) && (regularBox.getWeight() <= 70d);
        boolean isCount = (regularBox.getCount() >= 0) && (regularBox.getCount() <= 50);
        if (hasDelivery && hasReturn && isLength && isWidth && isHeight && isWeight && isCount) {
            deliver.add(regularBox);
            return true;
        } else { return false; }
    }

    public static boolean flat(Flat flat, ArrayList<Mail> deliver) {
        boolean hasDelivery = (!flat.getDeliveryAddress().isEmpty());
        boolean hasReturn = (!flat.getReturnAddress().isEmpty());
        boolean isLength = (flat.getLength() >= 11.5d) && (flat.getLength() <= 15d);
        boolean isWidth = (flat.getWidth() >= 6.125d) && (flat.getWidth() <= 12d);
        boolean isThick = (flat.getThickness() >= 0.25d) && (flat.getThickness() <= 0.75d);
        boolean containsDocuments = (flat.getContents().equals("DOCUMENTS"));
        if (hasDelivery && hasReturn && isLength && isWidth && isThick && containsDocuments) {
            deliver.add(flat);
            return true;
        } else { return false; }
    }

    public static boolean letter(Letter letter, ArrayList<Mail> deliver) {
        boolean hasDelivery = (!letter.getDeliveryAddress().isEmpty());
        boolean hasReturn = (!letter.getReturnAddress().isEmpty());
        boolean isLength = (letter.getLength() >= 5d) && (letter.getLength() <= 11.5d);
        boolean isWidth = (letter.getWidth() >= 3.5d) && (letter.getWidth() <= 6.125d);
        boolean isThick = (letter.getThickness() >= 0.007d) && (letter.getThickness() <= 0.25d);
        boolean isRectangle = ((letter.getLength() - letter.getWidth()) >= 1.5d);
        if (hasDelivery && hasReturn && isLength && isWidth && isThick && isRectangle) {
            deliver.add(letter);
            return true;
        } else { return false; }
    }
}