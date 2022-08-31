import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < 7) {
            int num = random.nextInt(39) + 1;
            if (!containsNumber(num)) {
                numbers.add(num);
            }
        }
    }

    public boolean equals(Object other) {
        return false;
    }
}