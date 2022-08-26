import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        sort(numbers);
    }

    public static int smallest(int[] arr) {
        int smallestNum = arr[0];
        for (int num : arr) {
            if (num < smallestNum) {
                smallestNum = num;
            }
        }
        return smallestNum;
    }

    public static int indexOfSmallest(int[] arr) {
        int smallestNum = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num < smallestNum) {
                smallestNum = num;
                index = i;
            }
        }
        return index;
    }

    public static int indexOfSmallestFrom(int[] arr, int startIndex) {
        int smallestNum = arr[startIndex];
        int index = startIndex;
        for (int i = startIndex; i < arr.length; i++) {
            int num = arr[i];
            if (num < smallestNum) {
                smallestNum = num;
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr));
            int index = indexOfSmallestFrom(arr, i);
            swap(arr, index, i);
        }
    }
}