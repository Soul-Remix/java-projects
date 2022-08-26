import java.util.ArrayList;
import java.util.List;

public class RecipesManager {
    private ArrayList<Recipe> recipes;

    public RecipesManager() {
        recipes = new ArrayList<>();
    }

    public void addRecipe(ArrayList<String> recipe) {
        String recipeName = recipe.get(0);
        int cookingTime = Integer.parseInt(recipe.get(1));
        ArrayList<String> ingredient = new ArrayList<>();
        for (int i = 2; i < recipe.size(); i++) {
            ingredient.add(recipe.get(i));
        }
        Recipe newRecipe = new Recipe(recipeName, cookingTime, ingredient);
        recipes.add(newRecipe);
    }

    public ArrayList<Recipe> findRecipeByName(String searchQuery) {
        ArrayList<Recipe> recipesFound = new ArrayList<>();
        recipes.forEach(r -> {
            if (r.getName().contains(searchQuery)) {
                recipesFound.add(r);
            }
        });
        return recipesFound;
    }

    public ArrayList<Recipe> findRecipeByTime(int maxTime) {
        ArrayList<Recipe> recipesFound = new ArrayList<>();
        recipes.forEach(r -> {
            if (r.getCookingTime() < maxTime) {
                recipesFound.add(r);
            }
        });
        return recipesFound;
    }

    public ArrayList<Recipe> findRecipeByIngredient(String searchQuery) {
        ArrayList<Recipe> recipesFound = new ArrayList<>();
        recipes.forEach(r -> {
            if (r.containIngredient(searchQuery)) {
                recipesFound.add(r);
            }
        });
        return recipesFound;
    }

    public void print() {
        recipes.forEach(System.out::println);
    }
}
