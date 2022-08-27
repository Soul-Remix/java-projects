public class CD implements Packable {
    private String artist;
    private String cdName;
    private int publishYear;
    private double weight;

    public CD(String artist, String cdName, int publishYear) {
        this.artist = artist;
        this.cdName = cdName;
        this.publishYear = publishYear;
        weight = 0.1;
    }

    @Override
    public double weight() {
        return weight;
    }

    public String toString() {
        return artist + ": " + cdName + " (" + publishYear + ")";
    }
}
