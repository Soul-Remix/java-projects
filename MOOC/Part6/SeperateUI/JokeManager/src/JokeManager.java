import java.util.ArrayList;
import java.util.Random;

public class JokeManager {
    private final ArrayList<String> jokes;

    public JokeManager() {
        jokes = new ArrayList<>();
    }

    public void addJoke(String joke) {
        jokes.add(joke);
    }

    public String drawJoke() {
        if (jokes.isEmpty()) {
            return "Jokes are in short supply.";
        }
        Random dice = new Random();
        int index = dice.nextInt(jokes.size());
        return jokes.get(index);
    }

    public void printJokes() {
        jokes.forEach(System.out::println);
    }
}
