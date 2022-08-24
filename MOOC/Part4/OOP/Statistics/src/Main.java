import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Statistics allNum = new Statistics();
        Statistics odd = new Statistics();
        Statistics even = new Statistics();

        System.out.println("Enter numbers;");

        while (true) {
            int num = Integer.parseInt(scanner.nextLine());

            if(num == -1) {
                break;
            }
            allNum.addNumber(num);

            if(num %2 ==0) {
                even.addNumber(num);
            }else {
                odd.addNumber(num);
            }
        }

        System.out.println("Sum: " + allNum.sum());
        System.out.println("Sum of odd numbers: " + odd.sum());
        System.out.println("Sum of even numbers: " + even.sum());
    }
}