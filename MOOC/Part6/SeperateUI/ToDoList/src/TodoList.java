import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> todos;

    public TodoList() {
        todos = new ArrayList<>();
    }

    public void add(String todo) {
        todos.add(todo);
    }

    public void remove(int todoNum) {
        todos.remove(todoNum - 1);
    }

    public void print() {
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ": " + todos.get(i));
        }
    }
}
