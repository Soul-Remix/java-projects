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

        // Return the cached priority value if not -1 or calculate it using the number of moves plus the manhattan value
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

        // Create tow min priority queue for the board and the twin board
        MinPQ<SearchNode> minPQ = new MinPQ<>();
        MinPQ<SearchNode> minPQTwin = new MinPQ<>();

        solution = new ArrayList<>();

        // Insert the initial board to the min priority queue
        minPQ.insert(new SearchNode(initial, 0, null));
        minPQTwin.insert(new SearchNode(initial.twin(), 0, null));

        while (true) {
            // Delete the minimum search node in the priority queue
            SearchNode node = minPQ.delMin();
            SearchNode nodeTwin = minPQTwin.delMin();

            Board board = node.board;
            Board boardTwin = nodeTwin.board;

            // Check if we reached the goal in the twin board and flag the board as unsolvable
            if (boardTwin.isGoal()) {
                isSolvable = false;
                break;
            }
            // Check if we reached the goal in the main board push the boards to the solution list
            if (board.isGoal()) {
                isSolvable = true;
                solution.add(board);
                while (node.previousNode != null) {
                    node = node.previousNode;
                    solution.add(node.board);
                }
                break;
            }

            // Increment the moves value
            node.moves++;
            nodeTwin.moves++;

            for (Board neighbor : node.board.neighbors()) {
                // Don’t enqueue a neighbor if its board is the same as the board of the previous search node in the game tree
                if ((node.previousNode != null && neighbor.equals(node.previousNode.board))) {
                    continue;
                }
                minPQ.insert(new SearchNode(neighbor, node.moves, node));
            }

            for (Board neighbor : nodeTwin.board.neighbors()) {
                // Don’t enqueue a neighbor if its board is the same as the board of the previous search node in the game tree
                if ((nodeTwin.previousNode != null && neighbor.equals(
                        nodeTwin.previousNode.board))) {
                    continue;
                }
                minPQTwin.insert(new SearchNode(neighbor, nodeTwin.moves, nodeTwin));
            }
        }
        // Reverse the solution list to start in the correct order
        Collections.reverse(solution);
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