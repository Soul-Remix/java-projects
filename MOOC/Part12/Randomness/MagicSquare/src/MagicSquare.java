import java.util.ArrayList;

public class MagicSquare {
    private int[][] magicSquare;

    public MagicSquare(int[][] magicSquare) {
        this.magicSquare = magicSquare;
    }

    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumOfRows = new ArrayList<>();
        int sum = 0;

        for (int[] ints : magicSquare) {
            for (int j = 0; j < ints.length; j++) {
                sum += ints[j];
                if (j == ints.length - 1) {
                    sumOfRows.add(sum);
                    sum = 0;
                }
            }
        }
        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumOfCols = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare.length; j++) {
                sum += magicSquare[j][i];
                if (j == magicSquare.length - 1) {
                    sumOfCols.add(sum);
                    sum = 0;
                }
            }
        }
        return sumOfCols;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumOfDiag = new ArrayList<>();
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < magicSquare.length; i++) {
            sumLeft += magicSquare[i][i];
            sumRight += magicSquare[i][magicSquare.length - i - 1];
        }
        sumOfDiag.add(sumLeft);
        sumOfDiag.add(sumRight);
        return sumOfDiag;
    }
}
