public class Item {
    private String name;
    private int weight;

    public Item(String giftName, int giftWeight) {
        name = giftName;
        weight = giftWeight;
    }


    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return name + " (" + weight + " kg)";
    }
}
