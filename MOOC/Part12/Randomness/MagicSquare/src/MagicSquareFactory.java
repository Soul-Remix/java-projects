public class MagicSquareFactory {
    public int[][] createMagicSquare(int side) {
        int[][] square = new int[side][side];
        int number = 1;
        int row = 0;
        int column = side / 2;
        int curr_row;
        int curr_col;
        while (number <= side * side) {
            square[row][column] = number;
            number++;
            curr_row = row;
            curr_col = column;
            row -= 1;
            column += 1;
            if (row == -1) {
                row = side - 1;
            }
            if (column == side) {
                column = 0;
            }
            if (square[row][column] != 0) {
                row = curr_row + 1;
                column = curr_col;
            }
        }
        return square;
    }
}
