import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArr = {4, 2, 9, 3, 0, 9, 1};
        System.out.println(Arrays.toString(intArr));
        sort(intArr);
        System.out.println(Arrays.toString(intArr));

        String[] stringArr = {"m", "c", "i", "e", "a"};
        System.out.println(Arrays.toString(stringArr));
        sort(stringArr);
        System.out.println(Arrays.toString(stringArr));

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(4);
        intList.add(9);
        intList.add(1);
        System.out.println(intList);
        sortIntegers(intList);
        System.out.println(intList);
    }

    public static void sort(int[] array) {
        Arrays.sort(array);
    }

    public static void sort(String[] array) {
        Arrays.sort(array);
    }

    public static void sortIntegers(ArrayList<Integer> integers) {
        integers.sort(null);
    }

    public static void sortStrings(ArrayList<String> strings) {
        strings.sort(null);
    }
}