import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final RecipesManager manager;

    public UserInterface(Scanner scanner, RecipesManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void start() {
        System.out.print("File to read: ");
        String file = scanner.nextLine();

        try {
            readFile(file);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return;
        }

        printCommands();

        label:
        while (true) {
            System.out.print("Enter Command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "stop":
                    break label;
                case "list":
                    manager.print();
                    break;
                case "find name":
                    System.out.print("Searched word: ");
                    String searchName = scanner.nextLine();
                    printRecipes(manager.findRecipeByName(searchName));
                    break;
                case "find cooking time":
                    System.out.print("Max cooking time: ");
                    int maxTime = Integer.parseInt(scanner.nextLine());
                    printRecipes(manager.findRecipeByTime(maxTime));
                    break;
                case "find ingredient":
                    System.out.print("Ingredient: ");
                    String searchIngredient = scanner.nextLine();
                    printRecipes(manager.findRecipeByIngredient(searchIngredient));
                    break;
            }
        }
    }

    public void readFile(String file) throws Exception {
        try {
            Scanner fileReader = new Scanner(Paths.get(file));
            ArrayList<String> items = new ArrayList<>();

            while (fileReader.hasNextLine()) {
                String row = fileReader.nextLine();
                if (row.isEmpty()) {
                    manager.addRecipe(items);
                    items.clear();
                    continue;
                }
                items.add(row);
            }
            manager.addRecipe(items);
            items.clear();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void printRecipes(ArrayList<Recipe> recipes) {
        if (recipes.size() == 0) {
            System.out.println("No recipes found");
        } else {
            recipes.forEach(System.out::println);
        }
    }

    public void printCommands() {
        System.out.println("Commands");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }
}
