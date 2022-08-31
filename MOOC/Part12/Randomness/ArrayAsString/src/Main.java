public class Main {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder builder = new StringBuilder();

        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                builder.append(ints[j]);
                if (j == ints.length - 1) {
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }
}