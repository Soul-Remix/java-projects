import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.TreeSet;

public class PointSET {
    private TreeSet<Point2D> set;

    // construct an empty set of points
    public PointSET() {
        set = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // number of points in the set
    public int size() {
        return set.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        set.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return set.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D point : set) {
            point.draw();
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Point2D> list = new ArrayList<>();
        for (Point2D p : set) {
            if (rect.contains(p)) {
                list.add(p);
            }
        }
        return list;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return null;
        }
        double distance = Double.POSITIVE_INFINITY;
        Point2D nearest = null;
        for (Point2D point : set) {
            double dis = p.distanceSquaredTo(point);
            if (dis < distance) {
                distance = dis;
                nearest = point;
            }
        }
        return nearest;
    }

    // unit testing of the methods
    public static void main(String[] args) {
        PointSET pointset = new PointSET();
        Point2D point1 = new Point2D(4, 7);
        Point2D point2 = new Point2D(5, 8);
        Point2D point3 = new Point2D(10, 12);
        pointset.insert(point1);
        pointset.insert(point2);
        pointset.insert(point3);

        System.out.println(pointset.contains(point1));
        System.out.println(pointset.size());
        Point2D point4 = new Point2D(10, 12);
        pointset.insert(point4);
        System.out.println(pointset.size());

        System.out.println(pointset.nearest(new Point2D(3, 9)));

        RectHV rectHV = new RectHV(4, 4, 6, 9);
        System.out.println(pointset.range(rectHV));
    }
}