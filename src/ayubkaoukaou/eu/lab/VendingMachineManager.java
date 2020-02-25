package ayubkaoukaou.eu.lab;
import java.util.Scanner;

public class VendingMachineManager extends Products {
    static int totalMoneyStored = 300;
    static String userChoice;
    static String userItemChoice;
    static int penny = 1;
    static int nickel = 5;
    static int dime = 10;
    static int quarter = 25;
    static Scanner userInput = new Scanner(System.in);
    static int credit = 0;

    public static int getCredit() {
        return credit;
    }

    public static void setCredit(int credit) {
        VendingMachineManager.credit = credit;
    }

    public static String getUserChoice() {
        return userChoice;
    }

    public static void setUserChoice(String userChoice) {
        VendingMachineManager.userChoice = userChoice;
    }

    public static String getUserItemChoice() {
        return userItemChoice;
    }

    public static void setUserItemChoice(String userItemChoice) {
        VendingMachineManager.userItemChoice = userItemChoice;
    }

    public static int getTotalMoneyStored() {
        return totalMoneyStored;
    }

    public static void setTotalMoneyStored(int totalMoneyStored) {
        VendingMachineManager.totalMoneyStored = totalMoneyStored;
    }

    public static int getPenny() {
        return penny;
    }

    public static void setPenny(int penny) {
        VendingMachineManager.penny = penny;
    }

    public static int getNickel() {
        return nickel;
    }

    public static void setNickel(int nickel) {
        VendingMachineManager.nickel = nickel;
    }

    public static int getDime() {
        return dime;
    }

    public static void setDime(int dime) {
        VendingMachineManager.dime = dime;
    }

    public static int getQuarter() {
        return quarter;
    }

    public static void setQuarter(int quarter) {
        VendingMachineManager.quarter = quarter;
    }


    public static void insertCoin() {

        System.out.println("Thank you for using SnackerWackers Ltd's official vending machine. \n " +
                "Insert coin or press 'Refund' to exit, \n 'Reset' to insert your coins again  or \n " +
                "'Purchase' to purchase an item. \n" +
                "Please press enter to begin and then insert your coin or select your options.");

        while (!(userInput.nextLine().equalsIgnoreCase("refund"))) {

            userChoice = userInput.next();
            if (userChoice.equalsIgnoreCase("penny")) {
                setCredit(credit + penny);
                System.out.println("Your credit is: " + credit);
            }


            if (userChoice.equalsIgnoreCase("nickel")) {
                setCredit(credit + nickel);
                System.out.println("Your credit is: " + credit);
            }

            if (userChoice.equalsIgnoreCase("dime")) {
                setCredit(credit + dime);
                System.out.println("Your credit is: " + credit);
            }

            if (userChoice.equalsIgnoreCase("quarter")) {
                setCredit(credit + quarter);
                System.out.println("Your credit is: " + credit);
            }


            if (userChoice.equalsIgnoreCase("Refund")) {
                setCredit(0);
                System.exit(-1);
            }

            if (userChoice.equalsIgnoreCase("Purchase")) {
                setUserChoice("Purchase");
                pickItem();
            }

            if (userChoice.equalsIgnoreCase("Reset")) {
                setCredit(0);
                System.out.println("Your credit has been reset to: " + credit + " Please insert your coin(s) again.");
            }
        }
    }

    public static void pickItem() {
        if (getUserChoice().equalsIgnoreCase("Purchase")) {

            System.out.println("Please select your item, Coke, Pepsi or Fanta. You can also select refund.");

            while (!(userInput.nextLine().equalsIgnoreCase("refund"))) {

                userItemChoice = userInput.next();
                if(userItemChoice.equalsIgnoreCase("Coke") && credit >= 25 ){
                    setCoke(getCoke() - 1);
                    System.out.println("There are now: " + getCoke() + " Cokes left. \n" +
                            "Please enjoy.");
                    setTotalMoneyStored(totalMoneyStored + 35);
                    setCredit(0);
                    System.exit(-1);
                }

                if(userItemChoice.equalsIgnoreCase("Fanta") && credit >= 45){
                    setFanta(getFanta() - 1);
                    System.out.println("There are now: " + getFanta() + " Fantas left. \n" +
                            "Please enjoy.");
                    setTotalMoneyStored(totalMoneyStored + 45);
                    setCredit(0);
                    System.exit(-1);
                }

                if(userItemChoice.equalsIgnoreCase("Pepsi") && credit >= 35){
                    setCoke(getPepsi() - 1);
                    System.out.println("There are now: " + getPepsi() + " Pepsis left. \n" +
                            "Please enjoy.");
                    setTotalMoneyStored(totalMoneyStored + 35);
                    setCredit(0);
                    System.exit(-1);
                }

                if(userItemChoice.equalsIgnoreCase("Fanta") && credit < 45){
                    System.out.println("Sorry, you do not have enough credit, please pick another or select refund and start again.");
                }

                if(userItemChoice.equalsIgnoreCase("Coke") && credit < 25){
                    System.out.println("Sorry, you do not have enough credit, please pick another or select refund and start again.");
                }

                if(userItemChoice.equalsIgnoreCase("Pepsi") && credit < 35){
                    System.out.println("Sorry, you do not have enough credit, please pick another or select refund and start again.");
                }

                if (userItemChoice.equalsIgnoreCase("Refund")) {
                    setCredit(0);
                    insertCoin();
                }


            }

        }
    }
}
