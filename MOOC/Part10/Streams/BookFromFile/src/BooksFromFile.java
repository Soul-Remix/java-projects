import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BooksFromFile {
    public static List<Book> readBooks(String file) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .filter(row -> row.length != 4)
                    .map(row -> new Book(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]), row[3]))
                    .forEach(books::add);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return books;
    }
}
