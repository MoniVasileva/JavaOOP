package workingWithAbsraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printRhombus(n);
    }

    public static void printRhombus(int size) {

        for (int i = 1; i <= size; i++) {
            printUpper(size, i);
        }
        for (int i = 1; i < size; i++) {
            printBottom(size, i);
        }

    }

    private static void printBottom(int size, int i) {

        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < size - i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printUpper(int size, int i) {

        for (int j = 0; j < size - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();

    }

}
