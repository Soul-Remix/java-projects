import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoList list;

    public UserInterface(Scanner scanner, TodoList list) {
        this.scanner = scanner;
        this.list = list;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (command.equals("add")) {
                System.out.print("To add: ");
                String input = scanner.nextLine();
                list.add(input);
            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int removeIndex = Integer.parseInt(scanner.nextLine());
                list.remove(removeIndex);
            } else if (command.equals("list")) {
                list.print();
            } else if (command.equals("end")) {
                System.out.println("Bye, Bye");
                break;
            } else {
                System.out.println("Unknown command ");
            }
        }
    }
}
