package assignment4.codec.driver_prompt;

import codec.file_types.*;

import java.util.Scanner;
import java.util.ArrayList;

public final class Driver {
    private Driver(){}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Media> allMedia = new ArrayList<>();
        userPrompt getInput = (msg) -> {
            System.out.print(msg);
            return in.nextLine();
        };
        while (true) {
            String command = prompt(getInput, "1. Add image\n2. Add music\n3. Add Video\n" +
                    "4. Show images\n5. Show music\n6. Show videos" +
                    "\n7. Show images and videos\n8. Show music and videos\nExit\nCommand: ");
            switch (command) {
                case "1" -> {
                    String name = prompt(getInput, "Name: ");
                    String imageCodec = prompt(getInput, "Image codec: ");
                    allMedia.add(new Image(name, imageCodec));
                }
                case "2" -> {
                    String name = prompt(getInput, "Name: ");
                    String audioCodec = prompt(getInput, "Audio codec: ");
                    allMedia.add(new Music(name, audioCodec));
                }
                case "3" -> {
                    String name = prompt(getInput, "Name: ");
                    String imageCodec = prompt(getInput, "Image codec: ");
                    String audioCodec = prompt(getInput, "Audio codec: ");
                    allMedia.add(new Video(name, imageCodec, audioCodec));
                }
                case "4" -> {
                    for (Media media : allMedia) {
                        if (media instanceof Image) {
                            System.out.println(((Image) media).getMediaInfo());
                        }
                    }
                }
                case "5" -> {
                    for (Media media : allMedia) {
                        if (media instanceof Music) {
                            System.out.println(((Music) media).getMediaInfo());
                        }
                    }
                }
                case "6" -> {
                    for (Media media : allMedia) {
                        if (media instanceof Video) {
                            System.out.println(((Video) media).getMediaInfo());
                        }
                    }
                }
                case "7" -> {
                    for (Media media : allMedia) {
                        if (media instanceof Video) {
                            System.out.println(((Video) media).getMediaInfo());
                        } else if (media instanceof Image) {
                            System.out.println(((Image) media).getMediaInfo());
                        }
                    }
                }
                case "8" -> {
                    for (Media media : allMedia) {
                        if (media instanceof Video) {
                            System.out.println(((Video) media).getMediaInfo());
                        } else if (media instanceof Music) {
                            System.out.println(((Music) media).getMediaInfo());
                        }
                    }
                }
                case "Exit" -> {}
                default -> System.out.println(command + " is not a command.");
            }
            if (command.equals("Exit")) { break; }
        }
    }

    private static String prompt(userPrompt func, String msg) { return func.prompt(msg); }
}