import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private double[] openedSites;
    private int trialsCount;
    
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        trialsCount = trials;
        openedSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int randRow = StdRandom.uniformInt(1, n + 1);
                int randCol = StdRandom.uniformInt(1, n + 1);
                percolation.open(randRow, randCol);
            }
            openedSites[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openedSites);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openedSites);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(trialsCount));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(trialsCount));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);

        String conf = "[" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]";
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " + conf);
    }

}