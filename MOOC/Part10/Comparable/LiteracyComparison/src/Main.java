import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Literacy> data = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .map(row -> new Literacy(
                                    row[0],
                                    row[1],
                                    row[2].trim().split(" ")[0],
                                    row[3],
                                    row[4],
                                    row[5]
                            )
                    )
                    .forEach(data::add);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        data.forEach(System.out::println);
    }
}