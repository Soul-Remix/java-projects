import java.util.ArrayList;

public class Stack {
    private final ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void add(String value) {
        stack.add(value);
    }

    public ArrayList<String> values() {
        return stack;
    }

    public String take() {
        if (this.isEmpty()) {
            return "";
        }
        int size = stack.size();
        String value = stack.get(size - 1);
        stack.remove(size - 1);
        return value;
    }
}
