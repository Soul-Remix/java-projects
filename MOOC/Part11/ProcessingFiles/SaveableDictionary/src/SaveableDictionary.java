import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> dictionary1;
    private HashMap<String, String> dictionary2;
    private String file;

    public SaveableDictionary(String file) {
        this.file = file;
        dictionary1 = new HashMap<>();
        dictionary2 = new HashMap<>();
    }

    public void add(String word, String translation) {
        dictionary1.putIfAbsent(word, translation);
        dictionary2.putIfAbsent(translation, word);
    }

    public String translate(String word) {
        String translation = dictionary1.getOrDefault(word, null);
        if (translation != null) {
            return translation;
        }
        translation = dictionary2.getOrDefault(word, null);
        return translation;
    }

    public void delete(String word) {
        String translation = dictionary1.getOrDefault(word, null);
        if (translation != null) {
            dictionary1.remove(word);
            dictionary2.remove(translation);
        } else {
            translation = dictionary2.getOrDefault(word, null);
            dictionary2.remove(word);
            dictionary1.remove(translation);
        }
    }

    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] lineSplit = line.split(":");
                dictionary1.put(lineSplit[0], lineSplit[1]);
                dictionary2.put(lineSplit[1], lineSplit[0]);
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter("words.txt")) {
            for (String word : dictionary1.keySet()) {
                String translation = dictionary1.get(word);
                writer.println(word + ":" + translation);
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
}
