public class Fitbyte {
    private int age;
    private int restingHeartRate;
    private double maximumHeartRate;

    public Fitbyte(int age, int restingHeartRate) {

        this.age = age;
        this.restingHeartRate = restingHeartRate;
        maximumHeartRate = 206.3 - (0.711 * age);
    }

    public double targetHeartRate(double percentageOfMaximum) {

        return (maximumHeartRate - restingHeartRate) * (percentageOfMaximum) + restingHeartRate;
    }
}
