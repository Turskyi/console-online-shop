package internetStore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private String filename = "products.dat";
    private Scanner scInt = new Scanner (System.in);
    private List<Product> basket = new ArrayList<> ( );
    private List<Product> products = new ArrayList<> ( );

    public Store() {
        products.add(new Smartphone ("Samsung J6",5000,"32 GB"));
        products.add(new Smartphone ("iPhone SX",9000,"32 GB"));
        products.add(new Shoes("Dr.Martens Air Wire",3000,43));
        products.add(new Shoes ("Crocs",4000,43));
        products.add(new Leptop ("Mac Book Pro",20000,2018));
}
    private void showMainMenu() {

        System.out.println ("\nMain menu.");
        System.out.println ("Press the number of the option you want: ");
        System.out.println ("1. Products \n2. Basket \n3. Get out from the internet store");
        selectAction ( );
    }

    private void clearTheBasket(){
        basket.removeAll (basket);
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ( filename))) {
            oos.writeObject (basket);
            System.out.println ("File has been written");
        } catch (Exception ex) {

            System.out.println (ex.getMessage ( ));
        }
        System.out.println ("Now your basket is empty." );
        showMainMenu ();
    }

    private void showBasket() {

        int j = 0;
        for (int i = 0; i < basket.size (); i++) {
            while (j < basket.size ( )) {
                j++;
            }
        }
        System.out.println ("Now in your basket: " + j + " product(s) ");
    }

    private void takeOutFile() {
        try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream (filename))) {

            basket = ((List<Product>) ois.readObject ( ));
        }
        catch (Exception ex) {

            System.out.println (ex.getMessage ( ));
        }
        showBasket ();
           for (Product p : basket)
               System.out.println (p);
        showProducts ( );
        }

    private void showProducts() {

        System.out.println ("\nPress the number of the product you want to add to your basket: ");
        for (int i = 0; i < products.size (); i++) {
            System.out.println (i + 1 + ". " + products.get (i).toString ( ));
        }
        System.out.println ("6. Main menu \n7. Remove everything from the basket");
        selectProduct ( );
    }

    private void selectAction() {
            int userInput = scInt.nextInt ( );
            switch (userInput) {
                case 1:
                    showProducts ( );
                    break;
                case 2:
                    takeOutFile ( );
                    break;
                case 3:
                    System.exit (0);
                default:
                    System.out.println ("Incorrect input");
                    break;
            }
    }

    private void selectProduct() {
            int userInput = scInt.nextInt ( );
            switch (userInput) {
                case 1:
                    basket.add (products.get (0));
                    saveFile();
                    break;
                case 2:
                    basket.add (products.get (1));
                    saveFile();
                    break;
                case 3:
                    basket.add (products.get (2));
                    saveFile();
                    break;
                case 4:
                    basket.add (products.get (3));
                    saveFile();
                    break;
                case 5:
                    basket.add (products.get (4));
                    saveFile();
                    break;
                case 6:
                    showMainMenu ( );
                    break;
                case 7:
                    clearTheBasket ();
                    break;
                default:
                    System.out.println ("Incorrect input");
                    break;
            }
        }
    private void saveFile() {

        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ( filename))) {
            oos.writeObject (basket);
            System.out.println ("File has been written");
        } catch (Exception ex) {

            System.out.println (ex.getMessage ( ));
        }
        takeOutFile ();
        showProducts ();
    }

    public void start() {
        showMainMenu ( );
    }
}








