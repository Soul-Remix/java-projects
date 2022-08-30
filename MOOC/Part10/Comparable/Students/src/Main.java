public class Main {
    public static void main(String[] args) {
        var student1 = new Student("name");
        var student2 = new Student("name");

        System.out.println(student1.compareTo(student2));
    }
}