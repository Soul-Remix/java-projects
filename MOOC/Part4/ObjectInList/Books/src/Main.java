import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Title: ");
            String bookTitle = scanner.nextLine();

            if(bookTitle.isEmpty()) {
                break;
            }

            System.out.print("Pages: ");
            int bookPages = Integer.parseInt(scanner.nextLine());

            System.out.print("Publish year: ");
            int publishYear = Integer.parseInt(scanner.nextLine());

            books.add(new Book(bookTitle,bookPages,publishYear));
        }
        System.out.print("What information will be printed: ");
        String info = scanner.nextLine();

        if(info.equals("everything")) {
            for(Book book : books) {
                System.out.println(book);
            }
        }else if(info.equals("name")) {
            for(Book book : books) {
                System.out.println(book.getTitle());
            }
        }
    }
}