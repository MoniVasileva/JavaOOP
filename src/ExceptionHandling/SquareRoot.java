package ExceptionHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = (scanner.nextLine());
       try {
           int number = Integer.parseInt(input);
        double result = sqrt(number);
           System.out.printf("%.2f\n",result);
       }catch (IllegalArgumentException e){
           System.out.println("Invalid");
       }
        System.out.println("Goodbye");
    }
    public static double sqrt(int n){
        if (n<0){
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(n);
    }
}
