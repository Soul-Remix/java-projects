public class Main {
    public static void main(String[] args) {
        Minute min = new Minute();

        while (true) {
            System.out.println(min);
            min.advance();

            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}