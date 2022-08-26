import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BirdsManager manager = new BirdsManager();
        UserInterface ui = new UserInterface(scanner, manager);

        ui.start();
    }
}