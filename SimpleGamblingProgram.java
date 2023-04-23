/*Java program that simulates a simple gambling game where the player starts
 with $100 and bets $1 on each round. The game continues until the player's 
 balance reaches $0 or $200.*/
 

package demo;
//Importing the Random class from java.util package
import java.util.Random;

public class SimpleGamblingGame {
	// Main method
    public static void main(String[] args) {
// Initializing the constant variables for initial balance, bet amount, and target balance
        final int INITIAL_BALANCE = 100;
        final int BET_AMOUNT = 1;
        final int TARGET_BALANCE = 200;
// Initializing the variable for balance, number of rounds, and a new instance of Random class
        int balance = INITIAL_BALANCE;
        int numRounds = 0;
        Random random = new Random();
        // Looping until balance reaches either 0 or target balance
        while (balance > 0 && balance < TARGET_BALANCE) {
            numRounds++;
            System.out.println("Round " + numRounds + ": Balance = $" + balance);

            // Placing bet
            boolean win = random.nextBoolean();
            if (win) {
                System.out.println("You won $1!");
                balance += BET_AMOUNT;
            } else {
                System.out.println("You lost $1!");
                balance -= BET_AMOUNT;
            }
        }
     // Checking the final balance
        if (balance == 0) {
            System.out.println("You went broke after " + numRounds + " rounds.");
        } else {
            System.out.println("Congratulations! You reached your target balance of $" + TARGET_BALANCE + " after " + numRounds + " rounds.");
        }
    }
}

