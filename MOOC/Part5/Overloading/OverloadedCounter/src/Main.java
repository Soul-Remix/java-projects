public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.increase();
        System.out.println(counter.value());

        counter.increase(10);
        System.out.println(counter.value());
    }
}