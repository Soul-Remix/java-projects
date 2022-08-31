public class Main {
    public static void main(String[] args) {
        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        boolean wasSuccessful = dictionary.load();

        if (wasSuccessful) {
            System.out.println("Successfully loaded the dictionary from file");
        }

        dictionary.add("banaani", "banana");
        dictionary.add("ohjelmointi", "programming");

        boolean saveSuccess = dictionary.save();

        if (saveSuccess) {
            System.out.println("Successfully saved the dictionary from file");
        }
    }
}