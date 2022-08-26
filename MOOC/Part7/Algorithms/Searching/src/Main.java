import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "book1");
        Book book2 = new Book(2, "book2");
        Book book3 = new Book(3, "book3");
        Book book4 = new Book(4, "book4");

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        System.out.println(binarySearch(books, 13));
    }

    public static int linearSearch(ArrayList<Book> books, int searchedId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == searchedId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(ArrayList<Book> books, int searchedId) {
        int numIndex = -1;
        int startIndex = 0;
        int endIndex = books.size();

        while (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            int middleNum = books.get(middleIndex).getId();

            if (middleNum == searchedId) {
                numIndex = middleIndex;
            } else if (middleNum > searchedId) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return numIndex;
    }
}