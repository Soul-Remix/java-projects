import java.util.ArrayList;

public class Herd {
    private ArrayList<Movable> movables;

    public Herd() {
        movables = new ArrayList<>();
    }

    public String toString() {
        String text = "";
        for (Movable m : movables) {
            text += m.toString() + "\n";
        }
        return text;
    }

    public void addToHerd(Movable movable) {
        movables.add(movable);
    }

    public void move(int dx, int dy) {
        movables.forEach(m -> {
            m.move(dx, dy);
        });
    }
}
