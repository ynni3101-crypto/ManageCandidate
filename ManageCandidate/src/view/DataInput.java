package view;

import java.time.Year;
import java.util.Scanner;

public class DataInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString() { 
        while (true) {
            String result = scanner.nextLine().trim();
            if (!result.isEmpty())
                return result;
            else System.out.println("Enter a valid value!");
        }
    }

    public static int inputNonNegativeInteger() {
        while (true) {
            try {
                int result = Integer.parseInt(inputString());
                if (result >= 0)
                    return result;
                else
                    System.out.println("Please input a non negative integer number.");
            } catch (NumberFormatException e) {
                System.err.println("Please input a non negative integer number.");
            }
        }
    }

    public static int inputLimit(int min, int max) {
        while (true) {
            int result = inputNonNegativeInteger();
            if (result >= min && result <=  max)
                return result;
            else
                System.out.println("Please input a number in the range [" + min + "; " + max + "]");
        }
    }

    public static int inputBirthYear() {
        int currentYear = Year.now().getValue();
        while (true) {
            try {
                int year = inputNonNegativeInteger();
                if (year >= 1990 && year <= currentYear) return year;
                System.out.println("Please input a value date.");
            } catch (NumberFormatException e) {
                System.out.println("Please input a value date.");
            }  
        }
    }

    public static String inputRegex(String regex) {
        while (true) {
            String s = inputString();
            if (s.matches(regex))
                return s;
            else
                System.out.println("Please input a value date.");
        }
    }
    public static String getPhone() {
        return inputRegex("\\d{10,}");
    }
    public static String getEmail() {
        return inputRegex("[a-z0-9.]{6,30}+@[a-z.]+");
    }
    public static int getExpYear() {
        return inputLimit(0, 100);
    }
    public static String getRank() {
        return inputRegex("Excellence|Good|Fair|Poor");
    }

    public static boolean inputYesNo() {
        System.out.println("Do you want to continue (Y/N)?");
        while (true) {
            String s = inputString();
            if (s.equalsIgnoreCase("Y")) 
                return true;
            if (s.equalsIgnoreCase("N"))
                return false;
            System.out.println("Please input Y or N.");
        }
    }
}
