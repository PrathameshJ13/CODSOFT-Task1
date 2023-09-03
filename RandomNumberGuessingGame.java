import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minValue = 1;
        int maxValue = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;
        int bestScore = Integer.MAX_VALUE;
        
        System.out.println("Welcome to the Random Number Guessing Game! \n");
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt( maxValue - minValue + 1) + minValue;
            int attempts = 0;
            
            System.out.println("Round " + (rounds + 1) + ": Guess the number between " + minValue + " and " +  maxValue);
            
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess <  minValue || userGuess > maxValue) {
                    System.out.println("Please enter a valid guess within the specified range.");
                } else if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number (" + randomNumber + ") in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too Low ! Try higher.");
                } else {
                    System.out.println("Too high ! Try lower.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry You lost the game \n You've reached the maximum number of attempts. \n The correct number was: "
                 + randomNumber);
            }
            
            totalAttempts += attempts;
            rounds++;
            
            if (attempts < bestScore) {
                bestScore = attempts;
            }
            
            System.out.println("\nCurrent Best Score: " + bestScore);
            System.out.print("Do you want to play again ? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        
        System.out.println("Thanks for playing! Your total score is based on attempts: " + totalAttempts);
        System.out.println("Exiting the Game . Goodbye!");

    }
}
