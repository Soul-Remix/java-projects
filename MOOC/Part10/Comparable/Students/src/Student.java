public class Student implements Comparable<Student>{
    private String name;

    public Student(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return name.compareToIgnoreCase(o.name);
    }
}
