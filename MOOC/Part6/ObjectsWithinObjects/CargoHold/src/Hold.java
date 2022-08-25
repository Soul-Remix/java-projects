import java.util.ArrayList;

public class Hold {
    private final ArrayList<Suitcase> suits;
    private final int maximumWeight;
    private int currentWeight;

    public Hold(int maxWeight) {
        maximumWeight = maxWeight;
        suits = new ArrayList<>();
        currentWeight = 0;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (currentWeight + suitcase.totalWeight() > maximumWeight) {
            return;
        }
        suits.add(suitcase);
        currentWeight += suitcase.totalWeight();
    }

    public void printItems() {
        suits.forEach(Suitcase::printItems);
    }

    public String toString() {
        String suitString = suits.size() + " suitcases ";

        if (suits.size() == 0) {
            suitString = "No suitcases ";
        }

        if (suits.size() == 1) {
            suitString = suits.size() + " suitcase ";
        }

        return suitString + "(" + currentWeight + " kg)";
    }
}
