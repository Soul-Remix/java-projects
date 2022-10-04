import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int[][] tiles;

    private int size;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        this.tiles = copyBoard(tiles);
        size = tiles.length;
    }

    // string representation of this board
    public String toString() {
        StringBuilder builer = new StringBuilder();
        builer.append(size + "\n");
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                builer.append(tiles[i][j] + "  ");
                if (j == tiles.length - 1) {
                    builer.append("\n");
                }
            }
        }
        return builer.toString();
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    // number of tiles out of place
    public int hamming() {
        int numOfTiles = 0;
        int idx = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                idx++;
                if (tiles[i][j] == 0) {
                    continue;
                }
                if (tiles[i][j] != idx) {
                    numOfTiles++;
                }
            }
        }
        return numOfTiles;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int[][] goalBoard = createGoalBoard(size);
        int distance = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j] == 0) {
                    continue;
                }
                Cell goalCell = findGoalCell(goalBoard, tiles[i][j]);
                distance += Math.abs(i - goalCell.x) + Math.abs(j - goalCell.y);
            }
        }
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        int[][] goalBoard = createGoalBoard(size);
        return Arrays.deepEquals(tiles, goalBoard);
    }

    // does this board equal y?
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Board board = (Board) obj;
        return size == board.size && Arrays.deepEquals(tiles, board.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighborsBoards = new ArrayList<>();
        Cell goalCell = findGoalCell(tiles, 0);

        if (goalCell.x - 1 >= 0) {
            Board b = exchangeCells(tiles, goalCell.x, goalCell.x - 1, goalCell.y, goalCell.y);
            neighborsBoards.add(b);
        }
        if (goalCell.y - 1 >= 0) {
            Board b = exchangeCells(tiles, goalCell.x, goalCell.x, goalCell.y, goalCell.y - 1);
            neighborsBoards.add(b);
        }
        if (goalCell.x + 1 < size) {
            Board b = exchangeCells(tiles, goalCell.x, goalCell.x + 1, goalCell.y, goalCell.y);
            neighborsBoards.add(b);
        }
        if (goalCell.y + 1 < size) {
            Board b = exchangeCells(tiles, goalCell.x, goalCell.x, goalCell.y, goalCell.y + 1);
            neighborsBoards.add(b);
        }
        return neighborsBoards;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] tilesCopy = copyBoard(this.tiles);

        boolean done = false;
        for (int i = 0; i < tilesCopy.length; i++) {
            for (int j = 0; j < tilesCopy.length - 1; j++) {
                if (tilesCopy[i][j] != 0 && tilesCopy[i][j + 1] != 0) {
                    int temp = tilesCopy[i][j + 1];
                    tilesCopy[i][j + 1] = tilesCopy[i][j];
                    tilesCopy[i][j] = temp;
                    done = true;
                    break;
                }
            }
            if (done) {
                break;
            }
        }

        return new Board(tilesCopy);
    }

    private int[][] createGoalBoard(int n) {
        int num = 1;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num == size * size) {
                    board[i][j] = 0;
                }
                else {
                    board[i][j] = num;
                }
                num++;
            }
        }
        return board;
    }

    private Cell findGoalCell(int[][] board, int num) {
        Cell cell = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == num) {
                    cell = new Cell(i, j);
                    break;
                }
            }
        }
        return cell;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] boardCopy = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        return boardCopy;
    }

    private Board exchangeCells(int[][] board, int startX, int endX, int startY, int endY) {
        int[][] tilesCopy = copyBoard(board);
        int temp = tilesCopy[endX][endY];
        tilesCopy[endX][endY] = 0;
        tilesCopy[startX][startY] = temp;
        return new Board(tilesCopy);
    }

    private class Cell {
        private int x;
        private int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] board = { { 1, 0, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
        Board b = new Board(board);
        Board b1 = new Board(board);
        System.out.println(b.hamming());
        System.out.println(b.manhattan());
        System.out.println(b);
        System.out.println(b.isGoal());
        System.out.println(b.equals(b1));
        for (Board bo : b.neighbors()) {
            System.out.println(bo);
        }
        System.out.println(b.twin());
    }
}