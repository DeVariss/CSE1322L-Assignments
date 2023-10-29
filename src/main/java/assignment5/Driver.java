package assignment5;

import java.util.Scanner;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public final class Driver {
    public static void main(String[] args) {
        try {
            new dnaFrame();
            strandMap = getMap();
            Scanner in = new Scanner(System.in);
            System.out.print("Enter strand: ");
            String strand = in
                    .nextLine()
                    .toUpperCase();
            in.close();
            if (DNALiB.validator(strand)) {
                strand = findStrand(strand);
                System.out.println("Your DNA sequence reversed and translated is:\n" + strand);
            } else
                System.out.println("Your DNA sequence is not valid.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File strandFile = new File("src", "strands.txt");
    private static HashMap<String, String> strandMap;

    private Driver() {}

    private static String findStrand(String strand) throws IOException {
        if (strandMap.containsKey(strand)) {
            System.out.println("Strand found in file!");
            return strandMap.get(strand);
        } else {
            System.out.println("Strand was not found, saved to file!");
            String handledStrand = handleStrand(strand);
            strandMap.put(strand, handledStrand);
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(strandFile));
            out.writeObject(strandMap);
            out.flush();
            out.close();
            return handledStrand;
        }
    }

    private static HashMap getMap() throws IOException, ClassNotFoundException {
        if (strandFile.exists()) {
            ObjectInputStream objIn = new ObjectInputStream(
                    new FileInputStream(strandFile));
            HashMap map = (HashMap) objIn.readObject();
            objIn.close();
            return map;
        } else
            return new HashMap<>();
    }

    private static String handleStrand(String strand) {
        strand = DNALiB.reverser(strand);
        strand = DNALiB.inverser(strand);
        strand = DNALiB.translator(strand);
        return strand;
    }
}