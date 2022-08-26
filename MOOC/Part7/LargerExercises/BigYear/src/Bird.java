public class Bird {
    private String name;
    private String latinName;
    private int observations;

    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        observations = 0;
    }

    public String getName() {
        return name;
    }

    public void increaseObservation() {
        observations++;
    }

    public String toString() {
        String observationString = observations + " observations";
        if (observations == 0) {
            observationString = "no observations";
        } else if (observations == 1) {
            observationString = observations + " observation";
        }

        return name + " (" + latinName + "): " + observationString;
    }
}
