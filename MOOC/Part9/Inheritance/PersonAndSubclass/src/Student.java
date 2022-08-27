public class Student extends Person {
    private int credits;

    public Student(String fullName, String address) {
        super(fullName, address);
        credits = 0;
    }

    public void study() {
        credits++;
    }

    public int credits() {
        return credits;
    }

    public String toString() {
        return super.toString() + "\n" + "  Study credits " + credits;
    }
}
