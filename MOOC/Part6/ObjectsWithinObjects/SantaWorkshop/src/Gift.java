public class Gift {
    private String name;
    private int weight;

    public Gift(String giftName,int giftWeight) {
        name= giftName;
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
