import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int target = random.nextInt(100) + 1; // 1-100
            int maxAttempts = 7;
            int attempt = 1;
            boolean won = false;

            System.out.println("Guess a number between 1 and 100!");

            while (attempt <= maxAttempts) {
                System.out.print("Attempt " + attempt + ": ");

                try {
                    int guess = scanner.nextInt();

                    if (guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue; // doesn't count as an attempt
                    }

                    if (guess == target) {
                        System.out.println("Correct! You guessed it in " + attempt + " attempts.");
                        won = true;
                        break;
                    } else if (guess > target) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Too low!");
                    }

                    attempt++;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a whole number, not text or symbols.");
                    scanner.next(); // clear the bad input from the scanner buffer
                    // doesn't count as an attempt
                }
            }

            if (!won) {
                System.out.println("Out of attempts! The number was " + target);
            }

            boolean validReplayInput = false;
            playAgain = false;

            while (!validReplayInput) {
                System.out.print("Play again? (yes/no): ");
                try {
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        playAgain = true;
                        validReplayInput = true;
                    } else if (response.equalsIgnoreCase("no")) {
                        playAgain = false;
                        validReplayInput = true;
                    } else {
                        System.out.println("Please type 'yes' or 'no'.");
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong. Please try again.");
                    scanner.next();
                }
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}