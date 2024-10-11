import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to generate a random number between min and max
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // Method that plays a single round of the game
    public static boolean playGame(int min, int max, int maxAttempts) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = generateRandomNumber(min, max);
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("I have generated a number between " + min + " and " + max + ". Can you guess it?");
        
        // Loop to handle the guessing logic
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }

            if (attempts == maxAttempts && !guessedCorrectly) {
                System.out.println("You've reached the maximum number of attempts! The correct number was " + randomNumber + ".");
            }
        }

        // Return whether the user guessed correctly
        return guessedCorrectly;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 20;
        int maxAttempts = 5;
        int roundsWon = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;

        // Main loop for playing multiple rounds
        while (playAgain) {
            roundsPlayed++;
            System.out.println("\n--- Round " + roundsPlayed + " ---");

            // Play one round and check if the user won
            boolean wonRound = playGame(min, max, maxAttempts);

            // If the user guessed correctly, increment roundsWon
            if (wonRound) {
                roundsWon++;
            }

            // Ask if the user wants to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            
            if (response.equalsIgnoreCase("yes")) {
                playAgain = true;
                break;
            } else if (response.equalsIgnoreCase("no")) {
                playAgain = false;
                break;
            } else {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
        }
    }
        // Display the final score
        System.out.println("\n--- Game Over ---");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}

