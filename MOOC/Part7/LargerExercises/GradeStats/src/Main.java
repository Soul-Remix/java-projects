import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointsManager manager = new PointsManager();
        UserInterface ui = new UserInterface(scanner, manager);

        ui.start();
    }
}