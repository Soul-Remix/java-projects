public class Counter {
    private int value;

    public Counter(int startValue) {
        value = startValue;
    }

    public Counter() {
        this(0);
    }

    public int value() {
        return value;
    }

    public void increase(int increaseBy) {
        value += increaseBy;
    }

    public void increase() {
        this.increase(1);
    }

    public void decrease(int decreaseBy) {
        value -= decreaseBy;
    }

    public void decrease() {
        this.decrease(1);
    }
}
