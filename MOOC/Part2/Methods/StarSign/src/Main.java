public class Main {
    public static void main(String[] args) {
        christmasTree(10);
    }

    public static void printStar(int repeat) {
        for (int i = 1; i <= repeat; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void printStarNoLine(int repeat) {
        for (int i = 1; i <= repeat; i++) {
            System.out.print("*");
        }
    }

    public static void printSpace(int repeat) {
        for (int i = 1; i <= repeat; i++) {
            System.out.print(" ");
        }
    }

    public static void printSquare(int size) {
        for (int i = 1; i <= size; i++) {
            printStar(size);
        }
        System.out.println("");
    }

    public static void printRectangle(int width, int height) {
        for (int i = 1; i <= height; i++) {
            printStar(width);
        }
        System.out.println("");
    }

    public static void printLeftTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printStar(i);
        }
        System.out.println("");
    }

    public static void printRightTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printSpace(size - i);
            printStar(i);
        }
        System.out.println("");
    }

    public static void christmasTreeBase(int height) {
        for (int i = 1; i <=2 ; i++) {
            printSpace(height -2);
            printStar(3);
        }
    }

    public static void christmasTree(int height) {
        for (int i = 0; i <height ; i++) {
            printSpace(height - i - 1);
            printStarNoLine(i * 2 + 1);
            System.out.println("");
        }
        christmasTreeBase(height);
    }
}