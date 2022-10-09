import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

public class KdTree {
    private Node root;

    private class Node {
        private Point2D value;
        private RectHV rect;
        private Node left, right;
        private int size;

        public Node(Point2D value) {
            this.value = value;
        }
    }

    // is the set empty?
    public boolean isEmpty() {

        return root == null;
    }

    // number of points in the set
    public int size() {
        return nodeSize(root);
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            root = new Node(p);
            root.rect = new RectHV(0, 0, 1, 1);
            root.size++;
            return;
        }
        root = insert(root, p, 0);
    }

    private Node insert(Node node, Point2D p, int depth) {
        if (node == null) {
            Node newNode = new Node(p);
            newNode.size = 1;
            return newNode;
        }
        if (depth % 2 == 0) {
            if (p.x() < node.value.x()) {
                node.left = insert(node.left, p, depth + 1);
                if (node.left.rect == null) {
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.value.x(),
                                                node.rect.ymax());
                }
            }
            else {
                if (!node.value.equals(p)) {
                    node.right = insert(node.right, p, depth + 1);
                    if (node.right.rect == null) {
                        node.right.rect = new RectHV(node.value.x(), node.rect.ymin(),
                                                     node.rect.xmax(), node.rect.ymax());
                    }
                }
            }
        }
        else {
            if (p.y() < node.value.y()) {
                node.left = insert(node.left, p, depth + 1);
                if (node.left.rect == null) {
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(),
                                                node.rect.xmax(), node.value.y());
                }
            }
            else {
                if (!node.value.equals(p)) {
                    node.right = insert(node.right, p, depth + 1);
                    if (node.right.rect == null) {
                        node.right.rect = new RectHV(node.rect.xmin(), node.value.y(),
                                                     node.rect.xmax(), node.rect.ymax());
                    }
                }
            }
        }
        node.size = 1 + nodeSize(node.left) + nodeSize(node.right);
        return node;
    }

    private int nodeSize(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return contains(p, root, 0);
    }

    private boolean contains(Point2D p, Node node, int depth) {
        if (node == null) {
            return false;
        }
        if (depth % 2 == 0) {
            if (p.x() < node.value.x()) {
                return contains(p, node.left, depth + 1);
            }
            else {
                if (node.value.equals(p)) {
                    return true;
                }
                return contains(p, node.right, depth + 1);
            }
        }
        else {
            if (p.y() < node.value.y()) {
                return contains(p, node.left, depth + 1);
            }
            else {
                if (node.value.equals(p)) {
                    return true;
                }
                return contains(p, node.right, depth + 1);
            }
        }
    }

    // draw all points to standard draw
    public void draw() {
        draw(root, 0);
    }

    private void draw(Node node, int depth) {
        if (node == null) {
            return;
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        node.value.draw();
        double sx = node.rect.xmin();
        double ex = node.rect.xmax();
        double sy = node.rect.ymin();
        double ey = node.rect.ymax();
        if (depth % 2 == 0) {
            StdDraw.setPenColor(StdDraw.RED);
            sx = node.value.x();
            ex = node.value.x();
        }
        else {
            StdDraw.setPenColor(StdDraw.BLUE);
            sy = node.value.y();
            ey = node.value.y();

        }
        StdDraw.line(sx, sy, ex, ey);
        draw(node.left, depth + 1);
        draw(node.right, depth + 1);
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Point2D> points = new ArrayList<>();
        range(rect, root, points);
        return points;
    }

    private void range(RectHV rect, Node node, ArrayList<Point2D> points) {
        if (node == null) {
            return;
        }
        if (rect.intersects(node.rect)) {
            if (rect.contains(node.value)) {
                points.add(node.value);
            }
            range(rect, node.left, points);
            range(rect, node.right, points);
        }
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return null;
        }
        double best = root.value.distanceSquaredTo(p);
        return nearest(root, p, root.value, best, 0);
    }

    private Point2D nearest(Node node, Point2D p, Point2D champ, double best, int depth) {
        if (node == null || best < node.rect.distanceSquaredTo(p)) return champ;
        best = champ.distanceSquaredTo(p);
        double temp = node.value.distanceSquaredTo(p);
        if (temp < best) {
            best = temp;
            champ = node.value;
        }

        if (depth % 2 == 0) {
            if (node.value.x() < p.x()) {
                champ = nearest(node.right, p, champ, best, depth + 1);
                if (node.left != null
                        && node.left.rect.distanceSquaredTo(p) < champ.distanceSquaredTo(p))
                    champ = nearest(node.left, p, champ, best, depth + 1);
            }
            else {
                champ = nearest(node.left, p, champ, best, depth + 1);
                if (node.right != null
                        && node.right.rect.distanceSquaredTo(p) < champ.distanceSquaredTo(p))
                    champ = nearest(node.right, p, champ, best, depth + 1);
            }
        }
        else {
            if (node.value.y() < p.y()) {
                champ = nearest(node.right, p, champ, best, depth + 1);
                if (node.left != null
                        && node.left.rect.distanceSquaredTo(p) < champ.distanceSquaredTo(p)) {
                    champ = nearest(node.left, p, champ, best, depth + 1);
                }

            }
            else {
                champ = nearest(node.left, p, champ, best, depth + 1);
                if (node.right != null
                        && node.right.rect.distanceSquaredTo(p) < champ.distanceSquaredTo(p))
                    champ = nearest(node.right, p, champ, best, depth + 1);

            }
        }
        return champ;
    }

    public static void main(String[] args) {
        KdTree kd = new KdTree();
        Point2D p1 = new Point2D(0.7, 0.2);
        Point2D p2 = new Point2D(0.5, 0.4);
        Point2D p3 = new Point2D(0.2, 0.3);
        Point2D p4 = new Point2D(0.4, 0.7);
        Point2D p5 = new Point2D(0.9, 0.6);

        kd.insert(p1);
        kd.insert(p2);
        kd.insert(p3);
        kd.insert(p4);
        kd.insert(p5);

        kd.draw();

        System.out.println(kd.contains(p5));
        System.out.println(kd.size());

        System.out.println(kd.range(new RectHV(0.3, 0.4, 0.5, 0.5)));
    }
}
