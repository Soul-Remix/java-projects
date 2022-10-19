import edu.princeton.cs.algs4.TST;

import java.util.HashMap;

public class BoggleSolver {
    private TST<Integer> dict;
    private HashMap<Integer, Integer[]> verticesCells;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        dict = new TST<>();
        for (int i = 0; i < dictionary.length; i++) {
            dict.put(dictionary[i], i);
        }
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
        // In in = new In(args[0]);
        // String[] dictionary = in.readAllStrings();
        // BoggleSolver solver = new BoggleSolver(dictionary);
        // BoggleBoard board = new BoggleBoard(args[1]);
        // int score = 0;
        // for (String word : solver.getAllValidWords(board)) {
        //     StdOut.println(word);
        //     score += solver.scoreOf(word);
        // }
        // StdOut.println("Score = " + score);


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
