import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearSum = 0;
        int count = 0;
        String longestName = "";
        int longestLength = 0;

        while (true) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }
            String[] lineArr = line.split(",");

            int birthYear = Integer.parseInt(lineArr[1]);
            count++;
            yearSum += birthYear;

            int length = lineArr[0].length();

            if( length> longestLength) {
                longestLength =length;
                longestName = lineArr[0];
            }
        }

        System.out.println("Longest name: " + longestName);
        double avg = (double) yearSum / count;
        System.out.println("Average: " + avg);
    }
}