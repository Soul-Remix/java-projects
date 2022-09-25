import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int top = 0;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF qf;
    private int count;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        grid = new boolean[size][size];
        count = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkBounds(row, col);
        if (isOpen(row, col)) {
            return;
        }

        count++;
        grid[row - 1][col - 1] = true;
        if (row == 1) {
            qf.union(getQFIndex(row, col), top);
        }
        if (row == size) {
            qf.union(getQFIndex(row, col), bottom);
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getQFIndex(row, col), getQFIndex(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            qf.union(getQFIndex(row, col), getQFIndex(row, col + 1));
        }
        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getQFIndex(row, col), getQFIndex(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            qf.union(getQFIndex(row, col), getQFIndex(row + 1, col));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkBounds(row, col);
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkBounds(row, col);
        return qf.find(top) == qf.find(getQFIndex(row, col));
    }

    // does the system percolate?
    public boolean percolates() {
        return qf.find(top) == qf.find(bottom);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    private int getQFIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    private void checkBounds(int row, int col) {
        if (row < 1 || col < 1 || row > size || col > size) {
            throw new IllegalArgumentException();
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(2);

        while (!percolation.percolates()) {
            int randRow = StdRandom.uniformInt(1, 3);
            int randCol = StdRandom.uniformInt(1, 3);
            percolation.open(randRow, randCol);
        }
        System.out.println(percolation.numberOfOpenSites());
    }
}
