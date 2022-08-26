import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private BirdsManager manager;

    public UserInterface(Scanner scanner, BirdsManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void start() {
        label:
        while (true) {
            System.out.print("? ");
            String command = scanner.nextLine();

            switch (command) {
                case "Add" -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Name in latin: ");
                    String latinName = scanner.nextLine();
                    manager.addBird(name, latinName);
                }
                case "Observation" -> {
                    System.out.print("Bird: ");
                    String birdName = scanner.nextLine();
                    boolean found = manager.addObservation(birdName);
                    if (!found) {
                        System.out.println("Not a bird!");
                    }
                }
                case "All" -> printBirds(manager.getAllBirds());
                case "One" -> {
                    System.out.print("Bird: ");
                    String birdNameToPrint = scanner.nextLine();
                    printBird(manager.getBird(birdNameToPrint));
                }
                case "Quit" -> {
                    break label;
                }
            }
        }
    }

    public void printBirds(ArrayList<Bird> birds) {
        if (birds.size() == 0) {
            System.out.println("No birds found, add more birds");
        } else {
            birds.forEach(System.out::println);
        }
    }

    public void printBird(Bird bird) {
        if (bird == null) {
            System.out.println("Bird not found");
        } else {
            System.out.println(bird);
        }
    }
}
