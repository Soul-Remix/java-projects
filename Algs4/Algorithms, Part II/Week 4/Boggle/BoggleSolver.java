import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;

import java.util.ArrayList;
import java.util.HashMap;

public class BoggleSolver {
    private final TST<Integer> dict;
    private HashMap<Integer, Integer[]> verticesCells;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        dict = new TST<>();
        for (int i = 0; i < dictionary.length; i++) {
            dict.put(dictionary[i], i);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        int rows = board.rows();
        int cols = board.cols();
        verticesCells = new HashMap<>();

        int[][] vertices = new int[rows][cols];
        int id = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                vertices[i][j] = id;
                verticesCells.put(id, new Integer[] { i, j });
                id++;
            }
        }

        Digraph digraph = new Digraph(cols * rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int vertixId = vertices[i][j];
                if (i > 0) {
                    digraph.addEdge(vertixId, vertices[i - 1][j]);
                }
                if (j > 0) {
                    digraph.addEdge(vertixId, vertices[i][j - 1]);
                }
                if (i < rows - 1) {
                    digraph.addEdge(vertixId, vertices[i + 1][j]);
                }
                if (j < cols - 1) {
                    digraph.addEdge(vertixId, vertices[i][j + 1]);
                }
                if (i > 0 && j > 0) {
                    digraph.addEdge(vertixId, vertices[i - 1][j - 1]);
                }
                if (i > 0 && j < cols - 1) {
                    digraph.addEdge(vertixId, vertices[i - 1][j + 1]);
                }
                if (i < rows - 1 && j < cols - 1) {
                    digraph.addEdge(vertixId, vertices[i + 1][j + 1]);
                }
                if (i < rows - 1 && j > 0) {
                    digraph.addEdge(vertixId, vertices[i + 1][j - 1]);
                }
            }
        }

        ArrayList<String> words = new ArrayList<>();
        boolean[] marked = new boolean[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            String word = "";
            dfs(digraph, i, marked, word, board, words);
        }

        return words;
    }

    private void dfs(Digraph g, int v, boolean[] marked, String word, BoggleBoard board,
                     ArrayList<String> words) {
        Integer[] cell = verticesCells.get(v);
        int i = cell[0];
        int j = cell[1];
        char letter = board.getLetter(i, j);
        if (letter == 'Q') {
            word += "QU";
        }
        else {
            word += letter;
        }
        if (!dict.keysWithPrefix(word).iterator().hasNext()) {
            return;
        }
        marked[v] = true;
        if (word.length() >= 3 && dict.contains(word) && !words.contains(word)) {
            words.add(word);
        }
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w, marked, word, board, words);
            }
        }
        marked[v] = false;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        int len = word.length();
        if (!dict.contains(word) || len < 3) {
            return 0;
        }
        if (len == 3 || len == 4) {
            return 1;
        }
        else if (len == 5) {
            return 2;
        }
        else if (len == 6) {
            return 3;
        }
        else if (len == 7) {
            return 5;
        }
        else {
            return 11;
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        int score = 0;
        for (String word : solver.getAllValidWords(board)) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);


        // Performance test
        // In in = new In(args[0]);
        // String[] dictionary = in.readAllStrings();
        // BoggleSolver solver = new BoggleSolver(dictionary);
        // int numOfLoops = 10000;
        // BoggleBoard[] boards = new BoggleBoard[numOfLoops];
        // for (int i = 0; i < numOfLoops; i++) {
        //     BoggleBoard board = new BoggleBoard();
        //     boards[i] = board;
        // }
        // Stopwatch watch = new Stopwatch();
        // for (int i = 0; i < numOfLoops; i++) {
        //     solver.getAllValidWords(boards[i]);
        // }
        // System.out.println("Time :" + watch.elapsedTime());
    }

}
