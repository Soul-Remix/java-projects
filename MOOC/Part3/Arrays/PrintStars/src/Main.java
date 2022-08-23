public class Main {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 2};
        printArrayInStars(array);
    }

    public static void printStar(int repeat) {
        for (int i = 0; i < repeat; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void printArrayInStars(int[] arr) {
        for (Integer num:arr) {
            printStar(num);
        }
    }
}