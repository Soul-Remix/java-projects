import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Item> items;
    private int maxWeight;
    private int currentWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
        currentWeight = 0;
    }

    public void addItem(Item item) {
        if (currentWeight + item.getWeight() > maxWeight) {
            return;
        }
        currentWeight += item.getWeight();
        items.add(item);
    }

    public void printItems() {
        items.forEach(i -> {
            System.out.println(i.getName() + " (" + i.getWeight() + " kg)");
        });
    }

    public int totalWeight() {
        return currentWeight;
    }

    public Item heaviestItem() {
        if (items.isEmpty()) {
            return null;
        }
        Item heaviest = items.get(0);

        for (Item i : items) {
            if (i.getWeight() > heaviest.getWeight()) {
                heaviest = i;
            }
        }

        return heaviest;
    }

    public String toString() {
        String itemString = items.size() + " items ";

        if (items.size() == 0) {
            itemString = "No items ";
        }

        if (items.size() == 1) {
            itemString = items.size() + " item ";
        }

        return itemString + "(" + currentWeight + " kg)";
    }
}
