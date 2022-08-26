import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final PointsManager manager;

    public UserInterface(Scanner scanner, PointsManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input == -1) {
                break;
            }
            if (input < 0 || input > 100) {
                continue;
            }

            manager.addPoint(input);
        }
        printAvg();
        printGrades();
    }

    public void printAvg() {
        System.out.println("Point average (all): " + manager.averageAll());
        double avgPass = manager.averagePassing();
        if (avgPass > 0) {
            System.out.println("Point average (passing): " + avgPass);
        } else {
            System.out.println("Point average (passing): -");
        }
        System.out.println("Pass percentage: " + manager.passPercentage());
    }

    public void printGrades() {
        System.out.println("Grade distribution");
        int grade = 5;
        while (grade >= 0) {
            int gradeCount = manager.gradeCount(grade);
            String stars = "*".repeat(gradeCount);
            System.out.println(grade + ": " + stars);
            grade--;
        }
    }
}
