public class Main {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 2};
        System.out.println("Sum: " + sum(array));
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (Integer num: nums) {
            sum += num;
        }
        return sum;
    }
}