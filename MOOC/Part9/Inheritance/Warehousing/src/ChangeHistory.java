import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        history = new ArrayList<>();
    }

    public void add(double status) {
        history.add(status);
    }

    public void clear() {
        history.clear();
    }

    public double maxValue() {
        if (history.size() == 0) {
            return 0;
        }
        double max = history.get(0);
        for (double num : history) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public double minValue() {
        if (history.size() == 0) {
            return 0;
        }
        double min = history.get(0);
        for (double num : history) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public double average() {
        double sum = 0;
        if (history.size() == 0) {
            return sum;
        }
        for (double num : history) {
            sum += num;
        }
        return sum / history.size();
    }

    public String toString() {
        return history.toString();
    }
}
