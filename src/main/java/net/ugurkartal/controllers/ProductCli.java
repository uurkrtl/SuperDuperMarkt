package net.ugurkartal.controllers;

import net.ugurkartal.business.abstracts.BaseService;
import net.ugurkartal.business.concrates.CheeseManager;
import net.ugurkartal.business.concrates.WineManager;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductCli {
    private static BaseService cheeseManager = new CheeseManager();
    private  static BaseService wineManager = new WineManager();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        System.out.println("1- Show all products");
        System.out.println("2- Show products in the following days");
        System.out.println("3- Exit");
        System.out.print("Enter your choice: ");
        int choice = 0;

        try {
            choice = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("Invalid choice");
            showMenu();
        }
        scanner.nextLine();

        switch (choice){
            case 1:
                wineManager.getAllProductsWithCurrentStatus().stream().forEach(System.out::println);
                cheeseManager.getAllProductsWithCurrentStatus().stream().forEach(System.out::println);
                System.out.println("-------------------------------------------------");
                showMenu();
                break;
            case 2:
                System.out.print("Enter the number of days: ");
                int days = scanner.nextInt();
                for(int i = 1; i<=days; i++){
                    System.out.println("Date: " + LocalDate.now().plusDays(i));
                        wineManager.makeOld();
                        cheeseManager.makeOld();
                    cheeseManager.getProducts().forEach((k,v) -> System.out.print(v));
                    wineManager.getProducts().forEach((k,v) -> System.out.print(v));
                    System.out.println("-------------------------------------------------");
                }
                showMenu();
                break;
            case 3:
                System.out.println("Program is being terminated...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                showMenu();
        }
    }
}