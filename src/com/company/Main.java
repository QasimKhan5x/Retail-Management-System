package com.company;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        /*try (Scanner scanner = new Scanner(Paths.get("testset.txt"))){
            UserInterface ui = new UserInterface(scanner);
            ui.start();
        } catch (Exception e) {
            System.out.println("File not found");
        }*/
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        ui.start();
    }
      
}
