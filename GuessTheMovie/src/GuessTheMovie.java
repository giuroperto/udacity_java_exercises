import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessTheMovie {
    static List<String> guess = new ArrayList<>();
    static boolean guessedLetter = false;
    static String wrongLetters = "";
    static boolean hasGuessed = false;
    static boolean isFinished = false;
    static int numGuesses = 10;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Game.setGameWord();

        while (!hasGuessed && !isFinished) {
            Game.printGuessedWord();
            String letter = userGuess();

            System.out.println("You are guessing: " + letter);
            System.out.print('\n');
            checkLetter(letter);
            nextRound();
        }
    }

    private static String userGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a letter: ");

        String response = scanner.nextLine().toUpperCase();

        while (response.length() > 1) {
            System.out.println("!!! Please remind, just one character at a time.");
            System.out.print("Guess a letter: ");
            response = scanner.nextLine().toUpperCase();
        }

        while (response.length() < 1) {
            System.out.println("You have to type a letter in order to continue with the game.");
            System.out.print("Guess a letter: ");
            response = scanner.nextLine().toUpperCase();
        }

        return response;
    }

    private static void checkLetter(String letter) {
        for(int i = 0; i < Game.numberLetters; i++) {
            if (Game.titleArray.get(i).equals(letter)) {
                guess.set(i, letter);
            }
        }

        guessedLetter = Game.selectedTitle.indexOf(letter.charAt(0)) != -1;

        if (!guessedLetter) wrongLetters += letter;
    }

    private static void nextRound() {
        if (!guess.contains("_")) {
            hasGuessed = true;
        }

        if (hasGuessed) {
            isFinished = true;
            System.out.println("==============================");
            System.out.println("YOU WON!");
            System.out.println("You have guessed the " + Game.selectedTitle + " correctly!");
            System.out.println("==============================");
        }

        if(!guessedLetter) {
            System.out.println("==============================");
            System.out.println("You have guessed " + wrongLetters.length()
                    + " wrong letter(s): " + wrongLetters);
            System.out.println("==============================");
            System.out.print('\n');

            if (numGuesses > 1) {
                numGuesses--;
            } else {
                isFinished = true;
                System.out.println("==============================");
                System.out.println("GAME OVER!");
                System.out.println("==============================");
            }
        }
    }
}

