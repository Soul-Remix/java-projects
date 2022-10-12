public class Outcast {
    private WordNet wordNet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        wordNet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int maxDistance = 0;
        String outcastNount = null;
        for (int i = 0; i < nouns.length; i++) {
            int distance = 0;
            for (int j = 0; j < nouns.length; j++) {
                distance += wordNet.distance(nouns[i], nouns[j]);
            }
            if (distance > maxDistance) {
                maxDistance = distance;
                outcastNount = nouns[i];
            }
        }
        return outcastNount;
    }

    // see test client below
    public static void main(String[] args) {
    }
}