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
            if (node.value.x() > p.x()) {
                node.right = insert(node.right, p, depth + 1);
                if (node.right.rect == null) {
                    node.right.rect = new RectHV(node.rect.xmin(), node.value.y(), node.rect.xmax(),
                                                 node.rect.ymax());
                }
            }
            else if (node.value.x() < p.x()) {
                node.left = insert(node.left, p, depth + 1);
                if (node.left.rect == null) {
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(),
                                                node.rect.xmax(), node.value.y());
                }
            }
            else {
                node.value = p;
            }
        }
        else {
            if (node.value.y() > p.y()) {
                node.right = insert(node.right, p, depth + 1);
                if (node.right.rect == null) {
                    node.right.rect = new RectHV(node.value.x(), node.rect.ymin(), node.rect.xmax(),
                                                 node.rect.ymax());
                }
            }
            else if (node.value.y() < p.y()) {
                node.left = insert(node.left, p, depth + 1);
                if (node.left.rect == null) {
                    node.left.rect = new RectHV(node.rect.xmin(), node.rect.ymin(), node.value.x(),
                                                node.rect.ymax());
                }
            }
            else {
                node.value = p;
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
        KdTree tree = new KdTree();
        Point2D point1 = new Point2D(4, 7);
        Point2D point2 = new Point2D(10, 12);
        Point2D point3 = new Point2D(5, 8);
        tree.insert(point1);
        tree.insert(point2);
        tree.insert(point3);


        System.out.println(tree.root.value);

        System.out.println(tree.contains(point2));
        System.out.println(tree.contains(point1));
        System.out.println(tree.contains(point3));
        System.out.println(tree.contains(new Point2D(3, 6)));
    }
}
