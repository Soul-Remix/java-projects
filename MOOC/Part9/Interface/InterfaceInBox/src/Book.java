public class Book implements Packable {
    private String author;
    private double weight;
    private String bookName;

    public Book(String author, String bookName, double weight) {
        this.author = author;
        this.weight = weight;
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return author + ": " + bookName;
    }

    @Override
    public double weight() {
        return weight;
    }
}
