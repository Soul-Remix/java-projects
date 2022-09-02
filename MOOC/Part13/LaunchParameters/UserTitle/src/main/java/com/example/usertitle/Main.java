package com.example.usertitle;

import javafx.application.Application;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        Application.launch(HelloApplication.class, "--title=" + title);
    }
}
