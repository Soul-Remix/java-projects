import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();

            if (bookName.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int bookAgeGroup = Integer.parseInt(scanner.nextLine());

            books.add(new Book(bookName, bookAgeGroup));
        }

        System.out.println(books.size() + " books in total.");

        if (books.size() == 0) {
            return;
        }

        System.out.println("Books:");
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeGroup)
                .thenComparing(Book::getName);

        books.sort(comparator);

        for (Book b : books) {
            System.out.println(b);
        }
    }
}