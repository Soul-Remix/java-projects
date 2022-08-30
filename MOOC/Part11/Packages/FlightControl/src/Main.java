import Views.TextUI;
import controllers.FlightControl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightControl controls = new FlightControl();
        TextUI ui = new TextUI(controls,scanner);

        ui.start();
    }
}