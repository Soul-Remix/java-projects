import edu.princeton.cs.algs4.Picture;

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
    }

}