public class Apartment {
    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        if (squares > compared.squares) {
            return true;
        }
        return false;
    }

    public int priceDifference(Apartment compared) {
        int currentPrice = squares * pricePerSquare;
        int comparedPrice = compared.squares * compared.pricePerSquare;

        return Math.abs(currentPrice - comparedPrice);
    }

    public boolean moreExpensiveThan(Apartment compared) {
        int currentPrice = squares * pricePerSquare;
        int comparedPrice = compared.squares * compared.pricePerSquare;

        if (currentPrice > comparedPrice) {
            return true;
        }
        return false;
    }
}
