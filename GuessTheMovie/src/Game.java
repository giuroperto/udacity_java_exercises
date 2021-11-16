import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    static List<String> moviesOptions = new ArrayList<>();
    static String selectedTitle;
    static List<String> titleArray = new ArrayList<>();
    static int numberLetters;

    private static void getMovies() {
        try {
            File file = new File("movies.txt");
            Scanner fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                moviesOptions.add(line.toUpperCase());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void getRandomMovie() {
        getMovies();
        int randomIndex = (int) (Math.random() * moviesOptions.size());
        selectedTitle = moviesOptions.get(randomIndex);
    }

    private static void createCharArray() {
        for(int i = 0; i < numberLetters; i++) {
            if(titleArray.get(i).matches("\\W")) {
                GuessTheMovie.guess.add(titleArray.get(i));
            } else {
                GuessTheMovie.guess.add("_");
            }
        }
    }

    public static void setGameWord() {
        getRandomMovie();
        titleArray = List.of(selectedTitle.split(""));
        numberLetters = titleArray.size();

        createCharArray();
    }

    public static void printGuessedWord() {
        System.out.println("#################### WORD ####################");
        for(int i = 0; i < numberLetters; i++) {
            System.out.print(GuessTheMovie.guess.get(i) + " ");
        }
        System.out.print('\n');
        System.out.println("##############################################");
        System.out.print('\n');
    }

}
