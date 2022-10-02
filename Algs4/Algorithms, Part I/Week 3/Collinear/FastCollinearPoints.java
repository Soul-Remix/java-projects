import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> segments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        checkInput(points);
        segments = new ArrayList<>();

        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        for (int i = 0; i < points.length; ++i) {
            Point origin = points[i];
            Arrays.sort(pointsCopy);
            Arrays.sort(pointsCopy, origin.slopeOrder());
            int count = 1;
            Point lineBeginning = null;
            for (int j = 0; j < pointsCopy.length - 1; ++j) {
                if (pointsCopy[j].slopeTo(origin) == pointsCopy[j + 1].slopeTo(origin)) {
                    count++;
                    if (count == 2) {
                        lineBeginning = pointsCopy[j];
                        count++;
                    }
                    else if (count >= 4 && j + 1 == pointsCopy.length - 1) {
                        if (lineBeginning.compareTo(origin) > 0) {
                            segments.add(new LineSegment(origin, pointsCopy[j + 1]));
                        }
                        count = 1;
                    }
                }
                else if (count >= 4) {
                    if (lineBeginning.compareTo(origin) > 0) {
                        segments.add(new LineSegment(origin, pointsCopy[j]));
                    }
                    count = 1;
                }
                else {
                    count = 1;
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

    public static void main(String[] args) {
        Point[] points = {
                new Point(19000, 10000), new Point(18000, 10000), new Point(32000, 10000),
                new Point(21000, 10000)
        };

        FastCollinearPoints br = new FastCollinearPoints(points);
        StdOut.println(br.numberOfSegments());
    }
}