import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {
    private ArrayList<Person> employees;

    public Employees() {
        employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.forEach(this::add);
    }

    public void print() {
        employees.forEach(System.out::println);
    }

    public void print(Education education) {
        employees.forEach(e -> {
            if (e.getEducation() == education) {
                System.out.println(e);
            }
        });
    }

    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
