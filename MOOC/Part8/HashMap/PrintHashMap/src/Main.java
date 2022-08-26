import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("f.e", "for example");
        hashmap.put("etc.", "and so on");
        hashmap.put("i.e", "more precisely");

        Program.printKeys(hashmap);
        System.out.println("---");
        Program.printKeysWhere(hashmap, "i");
        System.out.println("---");
        Program.printValuesOfKeysWhere(hashmap, ".e");
    }
}