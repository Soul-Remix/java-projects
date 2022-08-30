public class Literacy {
    private String theme;
    private String gender;
    private String ageGroup;
    private String country;
    private String year;
    private String literacyPercent;

    public Literacy(String theme, String ageGroup, String gender, String country, String year, String literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
        this.gender = gender;
    }

    public String toString() {
        return country + " (" + year + "), " + gender + ", " + literacyPercent;
    }
}
