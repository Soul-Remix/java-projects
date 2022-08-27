import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> items;
    private double maxWeight;

    public Box(double weight) {
        this.maxWeight = weight;
        items = new ArrayList<>();
    }

    public void add(Packable item) {
        double currentWeight = weight();
        if (currentWeight + item.weight() < maxWeight) {
            items.add(item);
        }
    }

    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            weight += item.weight();
        }
        return weight;
    }

    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
