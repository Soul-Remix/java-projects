import edu.princeton.cs.algs4.BellmanFordSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {
    private Picture picture;
    private int width;
    private int height;
    private int[][] pixels;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        this.picture = new Picture(picture);
        width = this.picture.width();
        height = this.picture.height();

        pixels = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = picture.get(j, i).getRGB();
            }
        }
    }

    // current picture
    public Picture picture() {
        return picture;
    }

    // width of current picture
    public int width() {
        return width;
    }

    // height of current picture
    public int height() {
        return height;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        validateWidth(x);
        validateHeight(y);
        if (x == 0 || x == width() - 1 || y == 0 || y == height() - 1) {
            return 1000;
        }

        Color color1, color2;

        color1 = new Color(pixels[y - 1][x]);
        color2 = new Color(pixels[y + 1][x]);
        double squareY = Math.pow(color1.getRed() - color2.getRed(), 2) + Math.pow(
                color1.getGreen() - color2.getGreen(), 2) + Math.pow(
                color1.getBlue() - color2.getBlue(), 2);
        color1 = new Color(pixels[y][x - 1]);
        color2 = new Color(pixels[y][x + 1]);
        double squareX = Math.pow(color1.getRed() - color2.getRed(), 2) + Math.pow(
                color1.getGreen() - color2.getGreen(), 2) + Math.pow(
                color1.getBlue() - color2.getBlue(), 2);
        return Math.sqrt(squareX + squareY);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        int[][] idx = new int[height()][width()];
        int numId = 0;
        int curr = 0;
        while (curr < width()) {
            for (int i = 0; i < height(); i++) {
                idx[i][curr] = numId;
                numId++;
            }
            curr++;
        }

        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(width() * height() + 1);

        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (j + 1 < width()) {
                    digraph.addEdge(new DirectedEdge(idx[i][j], idx[i][j + 1], energy(j, i)));
                    if (i + 1 < height()) {
                        digraph.addEdge(
                                new DirectedEdge(idx[i][j], idx[i + 1][j + 1], energy(j, i)));
                    }
                    if (i - 1 > 0) {
                        digraph.addEdge(
                                new DirectedEdge(idx[i][j], idx[i - 1][j + 1], energy(j, i)));
                    }
                }
                else {
                    digraph.addEdge(new DirectedEdge(idx[i][j], width() * height(), energy(j, i)));
                }
            }
        }

        double min = Double.POSITIVE_INFINITY;
        Iterable<DirectedEdge> pathIter = null;


        for (int i = 0; i < height(); i++) {
            BellmanFordSP sp = new BellmanFordSP(digraph, i);
            double dist = sp.distTo(width() * height());
            if (dist < min) {
                min = dist;
                pathIter = sp.pathTo(width() * height());
            }
        }

        int[] path = new int[width()];
        int id = 0;

        for (DirectedEdge edge : pathIter) {
            int from = edge.from();
            for (int i = 0; i < height(); i++) {
                if (idx[i][id] == from) {
                    path[id] = i;
                }
            }
            id++;
        }
        return path;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int[][] idx = new int[height()][width()];
        int numId = 0;
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                idx[i][j] = numId;
                numId++;
            }
        }

        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(width() * height() + 1);

        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (i + 1 < height()) {
                    digraph.addEdge(new DirectedEdge(idx[i][j], idx[i + 1][j], energy(j, i)));
                    if (j + 1 < width()) {
                        digraph.addEdge(
                                new DirectedEdge(idx[i][j], idx[i + 1][j + 1], energy(j, i)));
                    }
                    if (j - 1 > 0) {
                        digraph.addEdge(
                                new DirectedEdge(idx[i][j], idx[i + 1][j - 1], energy(j, i)));
                    }
                }
                else {
                    digraph.addEdge(new DirectedEdge(idx[i][j], width() * height(), energy(j, i)));
                }
            }
        }

        double min = Double.POSITIVE_INFINITY;
        Iterable<DirectedEdge> pathIter = null;

        for (int i = 0; i < width; i++) {
            BellmanFordSP sp = new BellmanFordSP(digraph, i);
            double dist = sp.distTo(width * height);
            if (dist < min) {
                min = dist;
                pathIter = sp.pathTo(width * height);
            }
        }

        int[] path = new int[height()];
        int id = 0;

        for (DirectedEdge edge : pathIter) {
            int from = edge.from();
            for (int i = 0; i < width(); i++) {
                if (idx[id][i] == from) {
                    path[id] = i;
                }
            }
            id++;
        }
        return path;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        validateHorizontalSeam(seam);
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        validateVerticalSeam(seam);
    }

    private void validateWidth(int num) {
        if (num < 0 || num > width() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateHeight(int num) {
        if (num < 0 || num > height() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateVerticalSeam(int[] seam) {
        if (seam.length != height() || width() <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < seam.length; i++) {
            validateHeight(seam[i]);
            if (i < seam.length - 1 && seam[i + 1] > (seam[i] + 1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateHorizontalSeam(int[] seam) {
        if (seam.length != width() || height() <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < seam.length; i++) {
            validateWidth(seam[i]);
            if (i < seam.length - 1 && seam[i + 1] > (seam[i] + 1)) {
                throw new IllegalArgumentException();
            }
        }
    }

    //  unit testing (optional)
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        SeamCarver carver = new SeamCarver(picture);

        System.out.println(carver.energy(0, 3));
        System.out.println(carver.findHorizontalSeam());
    }

}