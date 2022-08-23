import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 3;
        array[2] = 5;
        array[3] = 7;
        array[4] = 9;

        print(array);

        System.out.println("Give two indexes to swap");
        int index1 = Integer.parseInt(scanner.nextLine());
        int index2 = Integer.parseInt(scanner.nextLine());

        int helper = array[index1];
        array[index1] = array[index2];
        array[index2] = helper;

        print(array);
    }

    public static void print(int[] nums) {
        for (Integer num:nums) {
            System.out.println(num);
        }
    }
}