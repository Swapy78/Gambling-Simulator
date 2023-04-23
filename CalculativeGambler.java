/*Java program that implements the behavior of a calculative gambler
 who starts with a stake of $100 and bets $1 on each game.
  The gambler will continue playing until they have either won or lost 50%
  of their starting stake, at which point they will resign for the day*/
 
//Importing the necessary Java libraries
package demo;

import java.util.Random;

public class CalculativeGambler {
    
    public static void main(String[] args) {
    	// Declaring and initializing the constant variables
        final int STARTING_STAKE = 100;// the starting amount of money the gambler has
        int stake = STARTING_STAKE;// the current amount of money the gambler has
        int numGames = 0; // the number of games played
        Random rand = new Random();// a random number generator
        
     // Looping until the gambler has won or lost 50% of their stake
        while (stake > STARTING_STAKE / 2 && stake < STARTING_STAKE * 3 / 2) {
            numGames++;// incrementing the number of games played
            boolean win = rand.nextBoolean();// generating a random win or loss
            if (win) { // if the gambler wins
                stake += 1;// increasing the stake by 1
            } else { // if the gambler loses
                stake -= 1;// decreasing the stake by 1
            }
        }
        
     // Printing the final result depending on whether the gambler won or lost
        if (stake <= STARTING_STAKE / 2) {
            System.out.println("Resigning for the day after " + numGames + " games. Final stake: " + stake);
        } else {
            System.out.println("Resigning for the day after " + numGames + " games. Final stake: " + stake);
        }
    }
}

