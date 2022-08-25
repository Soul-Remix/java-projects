import java.util.ArrayList;

public class Package {
    private ArrayList<Gift> gifts;
    private int weight;

    public Package() {
        gifts =  new ArrayList<>();
        weight = 0;
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
        weight += gift.getWeight();
    }

    public int totalWeight(){
        return weight;
    }
}
