public class Book {
    private String name;
    private int ageGroup;

    public Book(String name, int ageGroup) {
        this.name = name;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public String toString() {
        return name + " (recommended for " + ageGroup + " year-olds or older)";
    }
}
