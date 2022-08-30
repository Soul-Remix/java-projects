import java.util.ArrayList;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        cards.forEach(System.out::println);
    }

    public void sort() {
        cards.sort(null);
    }

    public void sortBySuit() {
        this.sort();
        cards.sort((c1, c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());
    }

    @Override
    public int compareTo(Hand o) {
        int thisValueSum = this.cards.stream().map(Card::getValue).mapToInt(Integer::valueOf).sum();
        int objectValueSum = o.cards.stream().map(Card::getValue).mapToInt(Integer::valueOf).sum();

        return thisValueSum - objectValueSum;
    }
}
