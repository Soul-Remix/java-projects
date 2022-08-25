import java.util.ArrayList;

public class Menu {
    private final ArrayList<String> meals;

    public Menu() {
        meals = new ArrayList<>();
    }


    public void addMeal(String meal) {
        if (!meals.contains(meal)) {
            meals.add(meal);
        }
    }

    public void printMeals() {
        meals.forEach(System.out::println);
    }

    public void clearMenu() {
        meals.clear();
    }
}
