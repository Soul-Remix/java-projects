public class Minute {
    private ClockHand milliSecond = new ClockHand(100);
    private ClockHand second = new ClockHand(60);

    public void advance() {
        milliSecond.advance();

        if(milliSecond.value() == 0) {
            second.advance();
        }
    }

    public String toString() {
        return milliSecond + " : " + second;
    }
}
