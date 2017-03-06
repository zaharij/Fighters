package com.company;

/**
 * Created by Zakhar on 05.03.2017.
 */
public class DrawFighters {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public static void slideBorder(){
        System.out.println("******************");
    }

    public static void startBoxing(){
        System.out.println("___________");
        System.out.println(" ☺  ☺");
        System.out.println("/|\\ /|\\");
        System.out.println("/ \\ / \\");
        System.out.println("___________");
    }

    public static void lKicksR(){
        System.out.println("___________");
        System.out.println(" ☺__☹");
        System.out.println("/|  /|\\");
        System.out.println("/ \\ / \\");
        System.out.println("___________");
    }

    public static void rKicksL(){
        System.out.println("___________");
        System.out.println(" ☹__☺");
        System.out.println("/|\\  |\\");
        System.out.println("/ \\ / \\");
        System.out.println("___________");
    }

    public static void lBlockedR(){
        System.out.println("___________");
        System.out.println(" ☺/_☺");
        System.out.println("/|   |\\");
        System.out.println("/ \\ / \\");
        System.out.println("___________");
    }

    public static void rBlockedL(){
        System.out.println("___________");
        System.out.println(" ☺_\\☺");
        System.out.println("/|   |\\");
        System.out.println("/ \\ / \\");
        System.out.println("___________");
    }

    public static void lWinn(){
        System.out.println("___________");
        System.out.println("\\☺/");
        System.out.println(" |");
        System.out.print("/ \\ ");
        System.out.println(ANSI_RED + "\\\\__\\\\☹" + ANSI_RESET);
        System.out.println("___________");
    }

    public static void rWin() {
        System.out.println("___________");
        System.out.println("         \\☺/");
        System.out.println("          |");
        System.out.println(ANSI_RED + "☹//__//" + ANSI_RESET + " / \\ ");
        System.out.println("___________");
    }
}
