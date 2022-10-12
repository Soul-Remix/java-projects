import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

public class SAP {

    private Digraph digraph;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        digraph = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        validateInput(v);
        validateInput(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(bfsV, bfsW, Shortest.length);
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        validateInput(v);
        validateInput(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(bfsV, bfsW, Shortest.ancestor);
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        validateInput(v);
        validateInput(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(bfsV, bfsW, Shortest.length);
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        validateInput(v);
        validateInput(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);
        return sapHelper(bfsV, bfsW, Shortest.ancestor);
    }

    private enum Shortest {
        length,
        ancestor
    }

    private void validateInput(int num) {
        if (num < 0 || num > digraph.V() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInput(Iterable<Integer> nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        for (int num : nums) {
            validateInput(num);
        }
    }

    private Integer sapHelper(BreadthFirstDirectedPaths bfsv, BreadthFirstDirectedPaths bfsW,
                              Shortest shortest) {
        int minLen = Integer.MAX_VALUE;
        int ancestor = -1;

        for (int i = 0; i < digraph.V(); i++) {
            if (bfsv.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int vLen = bfsv.distTo(i);
                int wLen = bfsW.distTo(i);
                if (vLen + wLen < minLen) {
                    minLen = vLen + wLen;
                    ancestor = i;
                }
            }
        }

        if (shortest == Shortest.length) {
            return minLen < Integer.MAX_VALUE ? minLen : -1;
        }
        else {
            return ancestor;
        }
    }

    // do unit testing of this class
    public static void main(String[] args) {
    }
}