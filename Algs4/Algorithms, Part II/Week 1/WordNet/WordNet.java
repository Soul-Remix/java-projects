import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;

public class WordNet {
    private HashMap<String, Bag<Integer>> wordsMap;
    private HashMap<Integer, Bag<String>> idsMap;
    private Digraph digraph;
    private SAP sap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException();
        }

        wordsMap = new HashMap<>();
        idsMap = new HashMap<>();
        In synIn = new In(synsets);
        int count = 0;

        while (!synIn.isEmpty()) {
            String line = synIn.readLine();
            String[] lineSplit = line.split(",");
            int id = Integer.parseInt(lineSplit[0]);
            String[] nouns = lineSplit[1].split(" ");
            Bag<String> words = new Bag<>();
            for (int i = 0; i < nouns.length; i++) {
                words.add(nouns[i]);
                Bag<Integer> ids = new Bag<>();
                if (wordsMap.containsKey(nouns[i])) {
                    ids = wordsMap.get(nouns[i]);
                }
                ids.add(id);
                wordsMap.put(nouns[i], ids);
            }
            idsMap.put(id, words);
            count++;
        }

        digraph = new Digraph(count);

        In hyperIn = new In(hypernyms);
        while (!hyperIn.isEmpty()) {
            String line = hyperIn.readLine();
            String[] lineSplit = line.split(",");
            int v = Integer.parseInt(lineSplit[0]);
            for (int i = 1; i < lineSplit.length; i++) {
                int w = Integer.parseInt(lineSplit[i]);
                digraph.addEdge(v, w);
            }
        }

        sap = new SAP(digraph);
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return wordsMap.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        return wordsMap.containsKey(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        Bag<Integer> idA = wordsMap.get(nounA);
        Bag<Integer> idB = wordsMap.get(nounB);
        return sap.length(idA, idB);
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        Bag<Integer> idA = wordsMap.get(nounA);
        Bag<Integer> idB = wordsMap.get(nounB);
        int ancestor = sap.ancestor(idA, idB);
        if (ancestor == -1) {
            return "None";
        }
        return idsMap.get(ancestor).toString();
    }


    // do unit testing of this class
    public static void main(String[] args) {
        WordNet wordNet = new WordNet(args[0], args[1]);
    }
}