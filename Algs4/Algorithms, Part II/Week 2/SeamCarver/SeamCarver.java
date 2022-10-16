import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {
    private int width;
    private int height;
    private double[][] energyMatrix;
    private int[][] colorMatrix;
    private boolean transposed;

    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException();
        }
        width = picture.width();
        height = picture.height();

        buildM(picture);

        transposed = false;
    }

    private void buildM(Picture p) {
        energyMatrix = new double[width][height];
        colorMatrix = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // caution: this is a transposed matrix
                Color c = p.get(i, j);
                colorMatrix[i][j] = c.getRed() + c.getGreen() * 256 + c.getBlue() * 65536;
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                energyMatrix[i][j] = calculateEnergy(i, j);
            }
        }
    }

    private double calculateEnergy(int i, int j) {
        if (i == 0 || i == width - 1 || j == 0 || j == height - 1) {
            return 1000;
        }
        else {
            double deltax = difference(colorMatrix[i - 1][j], colorMatrix[i + 1][j]);
            double deltay = difference(colorMatrix[i][j - 1], colorMatrix[i][j + 1]);
            return Math.sqrt(deltax + deltay);
        }
    }

    private double difference(int c1, int c2) {
        int[] rgb1 = rgb(c1);
        int[] rgb2 = rgb(c2);
        double dr = Math.pow((double) rgb1[0] - rgb2[0], 2);
        double dg = Math.pow((double) rgb1[1] - rgb2[1], 2);
        double db = Math.pow((double) rgb1[2] - rgb2[2], 2);
        return dr + dg + db;
    }

    private int[] rgb(int c) {
        int[] rgb = new int[3];
        rgb[2] = c / 65536;
        c %= 65536;
        rgb[1] = c / 256;
        rgb[0] = c % 256;
        return rgb;
    }

    private void transpose() {
        int t = width;
        width = height;
        height = t;
        double[][] energyT = new double[width][height];
        int[][] colorT = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                energyT[i][j] = energyMatrix[j][i];
                colorT[i][j] = colorMatrix[j][i];
            }
        }
        energyMatrix = energyT;
        colorMatrix = colorT;

        transposed = !transposed;
    }

    public Picture picture() {
        if (transposed) {
            transpose();
        }
        Picture p = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int[] rgb = rgb(colorMatrix[i][j]);
                p.set(i, j, new Color(rgb[0], rgb[1], rgb[2]));
            }
        }
        return p;
    }

    public int width() {
        if (transposed) {
            return height;
        }
        else {
            return width;
        }
    }

    public int height() {
        if (transposed) {
            return width;
        }
        else {
            return height;
        }
    }

    public double energy(int x, int y) {
        if (x < 0 || width() <= x || y < 0 || height() <= y) {
            throw new IllegalArgumentException();
        }
        if (transposed) {
            return energyMatrix[y][x];
        }
        else {
            return energyMatrix[x][y];
        }
    }

    public int[] findHorizontalSeam() {
        if (transposed) {
            transpose();
        }
        return findHSeam();
    }

    private int[] findHSeam() {
        int[] result = new int[width];
        if (2 < height) {
            double[][] distTo = buildDistTo();
            int[][] edgeTo = new int[width][height];
            for (int i = 0; i < width - 1; i++) {
                for (int j = 1; j < height - 1; j++) {
                    relax(i, j, distTo, edgeTo);
                }
            }
            int ry = 1;
            for (int j = 1; j < height - 1; j++) {
                if (distTo[width - 1][j] < distTo[width - 1][ry]) {
                    ry = j;
                }
            }

            for (int i = width - 1; 0 <= i; i--) {
                result[i] = ry;
                ry = edgeTo[i][ry];
            }
        }

        return result;
    }

    private void relax(int x, int y, double[][] distTo, int[][] edgeTo) {
        for (int j = y - 1; j <= y + 1; j++) {
            double d = distTo[x][y] + energyMatrix[x + 1][j];
            if (d < distTo[x + 1][j]) {
                distTo[x + 1][j] = d;
                edgeTo[x + 1][j] = y;
            }
        }
    }

    public int[] findVerticalSeam() {
        if (!transposed) {
            transpose();
        }
        return findHSeam();
    }

    private double[][] buildDistTo() {
        double[][] distTo = new double[width][height];
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < height; j++) {
                distTo[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        return distTo;
    }

    private void validate(int[] seam) {
        if (seam == null) {
            throw new IllegalArgumentException();
        }
        if (seam.length != width || height < 2) {
            throw new IllegalArgumentException();
        }
        int pre = seam[0];
        for (int s : seam) {
            if (s < 0 || height <= s || 1 < Math.abs(s - pre)) {
                throw new IllegalArgumentException();
            }
            else {
                pre = s;
            }
        }
    }


    public void removeHorizontalSeam(int[] seam) {  // remove horizontal seam from current picture
        if (transposed) {
            transpose();
        }
        removeHSeam(seam);
    }

    private void removeHSeam(int[] seam) {
        validate(seam);
        height--;
        for (int i = 0; i < width; i++) {
            System.arraycopy(energyMatrix[i], seam[i] + 1, energyMatrix[i], seam[i],
                             height - seam[i]);
            System.arraycopy(colorMatrix[i], seam[i] + 1, colorMatrix[i], seam[i],
                             height - seam[i]);
        }
        for (int i = 1; i < width - 1; i++) {
            if (0 < seam[i]) {
                energyMatrix[i][seam[i] - 1] = calculateEnergy(i, seam[i] - 1);
            }
            if (seam[i] < height) {
                energyMatrix[i][seam[i]] = calculateEnergy(i, seam[i]);
            }
        }
    }

    public void removeVerticalSeam(int[] seam) {    // remove vertical seam from current picture
        if (!transposed) {
            transpose();
        }
        removeHSeam(seam);
    }

    //  unit testing (optional)
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        SeamCarver carver = new SeamCarver(picture);

        System.out.println(carver.energy(3, 3));
        carver.removeVerticalSeam(carver.findVerticalSeam());
        carver.removeHorizontalSeam(carver.findHorizontalSeam());
        Picture pic = carver.picture();
        System.out.println(carver.width() + "    " + pic.width());
        System.out.println(carver.height() + "    " + pic.height());
        carver.removeHorizontalSeam(carver.findHorizontalSeam());
    }

}