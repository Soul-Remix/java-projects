public class Card implements Comparable<Card> {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        String valueToString = value + "";

        if (value == 11) {
            valueToString = "J";
        } else if (value == 12) {
            valueToString = "Q";
        } else if (value == 13) {
            valueToString = "K";
        } else if (value == 14) {
            valueToString = "A";
        }
        return suit + " " + valueToString;
    }

    @Override
    public int compareTo(Card o) {
        int comparedValue = this.value - o.value;

        if (comparedValue != 0) {
            return comparedValue;
        }
        return this.suit.ordinal() - o.suit.ordinal();
    }
}
