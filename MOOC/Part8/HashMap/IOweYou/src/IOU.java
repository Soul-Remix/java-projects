import java.util.HashMap;

public class IOU {
    private final HashMap<String, Double> debts;

    public IOU() {
        debts = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        debts.put(sanitizeString(toWhom), amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return debts.getOrDefault(sanitizeString(toWhom), 0.0);
    }

    public String sanitizeString(String text) {
        return text.trim().toLowerCase();
    }
}
