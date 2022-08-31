import java.util.ArrayList;

public class Pipe<T> {
    private final ArrayList<T> items;

    public Pipe() {
        items = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        items.add(value);
    }

    public T takeFromPipe() {
        if (items.size() == 0) {
            return null;
        }
        return items.remove(0);
    }

    public boolean isInPipe() {
        return items.size() > 0;
    }
}
