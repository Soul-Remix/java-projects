import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
    private Node root;
    private int size;

    private class Node {
        private Point2D value;
        private RectHV rect;
        private Node left, right;

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
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            root = new Node(p);
            root.rect = new RectHV(0, 0, 1, 1);
            size++;
            return;
        }
        root = insert(root, p, 0);
        size++;
    }

    private Node insert(Node node, Point2D p, int depth) {
        if (node == null) {
            return new Node(p);
        }
        if (depth % 2 == 0) {

            if (p.x() < node.value.x()) {
                node.left = insert(node.left, p, depth + 1);
                if (node.left.rect == null) {
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(),
                                                node.value.x(), node.rect.ymax());
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
        return node;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        int depth = 0;
        Node x = root;
        while (x != null) {
            if (depth % 2 == 0) {
                if (x.value.x() > p.x()) {
                    x = x.right;
                }
                else if (x.value.x() < p.x()) {
                    x = x.left;
                }
                else {
                    return true;
                }
            }
            else {
                if (x.value.y() > p.y()) {
                    x = x.right;
                }
                else if (x.value.y() < p.y()) {
                    x = x.left;
                }
                else {
                    return true;
                }
            }
            depth++;
        }
        return false;
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

    }
}
