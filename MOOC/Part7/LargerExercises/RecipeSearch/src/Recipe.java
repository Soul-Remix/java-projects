import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final String name;
    private final int cookingTime;
    private final ArrayList<String> ingredients;

    public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public boolean containIngredient(String ingredient) {
        return ingredients.contains(ingredient);
    }

    public String toString() {
        return name + ", Cooking time " + cookingTime;
    }
}
