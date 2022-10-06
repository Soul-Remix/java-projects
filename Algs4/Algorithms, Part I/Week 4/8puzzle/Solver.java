import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Collections;

public class Solver {
    private ArrayList<Board> solution;
    private boolean isSolvable;

    private class SearchNode implements Comparable<SearchNode> {
        private int moves;
        private Board board;
        private SearchNode previousNode;
        private int cachedPriority = -1;

        public SearchNode(Board board, int moves, SearchNode previousNode) {
            this.board = board;
            this.moves = moves;
            this.previousNode = previousNode;
        }

        private int priority() {
            if (cachedPriority == -1) {
                cachedPriority = moves + board.manhattan();
            }
            return cachedPriority;
        }

        public int compareTo(SearchNode that) {
            if (this.priority() < that.priority()) {
                return -1;
            }
            if (this.priority() > that.priority()) {
                return +1;
            }
            return 0;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }

        MinPQ<SearchNode> minPQ = new MinPQ<>();
        MinPQ<SearchNode> minPQTwin = new MinPQ<>();
        solution = new ArrayList<>();

        minPQ.insert(new SearchNode(initial, 0, null));
        minPQTwin.insert(new SearchNode(initial.twin(), 0, null));

        while (true) {
            SearchNode node = minPQ.delMin();
            SearchNode nodeTwin = minPQTwin.delMin();

            Board board = node.board;
            Board boardTwin = nodeTwin.board;

            if (boardTwin.isGoal()) {
                isSolvable = false;
                break;
            }
            if (board.isGoal()) {
                isSolvable = true;
                solution.add(board);
                while (node.previousNode != null) {
                    node = node.previousNode;
                    solution.add(node.board);
                }
                break;
            }

            node.moves++;
            nodeTwin.moves++;

            for (Board neighbor : node.board.neighbors()) {
                if ((node.previousNode != null && neighbor.equals(node.previousNode.board))) {
                    continue;
                }
                minPQ.insert(new SearchNode(neighbor, node.moves, node));
            }

            for (Board neighbor : nodeTwin.board.neighbors()) {
                if ((nodeTwin.previousNode != null && neighbor.equals(
                        nodeTwin.previousNode.board))) {
                    continue;
                }
                minPQTwin.insert(new SearchNode(neighbor, nodeTwin.moves, nodeTwin));
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        }
        return solution.size() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }
        Collections.reverse(solution);
        return solution;
    }

    // test client (see below) 
    public static void main(String[] args) {
        int[][] array = { { 5, 2, 3 }, { 4, 7, 0 }, { 8, 6, 1 } };
        Board board = new Board(array);
        Solver solver = new Solver(board);
        System.out.println(solver.moves());
        for (Board node : solver.solution()) {
            System.out.println(node);
            System.out.println("_______");
        }
    }

}