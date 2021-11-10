import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        int random = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("#######################################");
        System.out.println("###########GUESS THE NUMBER############");
        System.out.println("#######################################");
        System.out.println("I've selected a random number from 1 to 100. Try to guess it!");

        for(int i = 10; i >= 1; i--) {
            System.out.println("You have " + i + " guess(es):");
            int guess = scanner.nextInt();

            if (guess > random) {
                System.out.println("The number is lesser than " + guess);
            } else if (guess < random) {
                System.out.println("The number is greater than " + guess);
            } else {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("#######################################");
            System.out.println("CORRECT!!! You won!");
            System.out.println("#######################################");
        } else {
            System.out.println("#######################################");
            System.out.println("Oh no! You lost! :/");
            System.out.println("#######################################");
        }
    }
}
