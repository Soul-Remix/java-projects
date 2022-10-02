import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        checkInput(points);
        segments = new ArrayList<>();

        int n = points.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int m = k + 1; m < n; m++) {
                        if (isCollinear(points[i], points[j], points[k], points[m])) {
                            LineSegment lineSegment = new LineSegment(points[i], points[m]);
                            if (!segments.contains(lineSegment)) {
                                segments.add(lineSegment);
                            }
                        }
                    }
                }
            }
        }

    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        int n = numberOfSegments();
        LineSegment[] segArrCopy = new LineSegment[n];
        for (int i = 0; i < n; i++) {
            segArrCopy[i] = segments.get(i);
        }
        return segArrCopy;
    }

    private void checkInput(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        Arrays.sort(points, points[0].slopeOrder());
        for (int i = 0; i < points.length; i++) {
            if (i != points.length - 1) {
                if (points[i].compareTo(points[i + 1]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static boolean isCollinear(Point a, Point b, Point c, Point d) {
        if (a.slopeTo(b) == a.slopeTo(c)) return (a.slopeTo(b) == a.slopeTo(d));
        else return false;
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(19000, 10000), new Point(18000, 10000), new Point(32000, 10000),
                new Point(21000, 10000)
        };

        BruteCollinearPoints br = new BruteCollinearPoints(points);
        StdOut.println(br.numberOfSegments());
    }
}


