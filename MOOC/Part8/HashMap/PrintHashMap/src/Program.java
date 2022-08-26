import java.util.HashMap;

public class Program {
    public static void printKeys(HashMap<String, String> hashmap) {
        for (String str : hashmap.keySet()) {
            System.out.println(str);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String str : hashmap.keySet()) {
            if (str.contains(text)) {
                System.out.println(str);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String str : hashmap.keySet()) {
            if (str.contains(text)) {
                System.out.println(hashmap.get(str));
            }
        }
    }
}
