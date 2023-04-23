//Java program that simulates gambling with a starting stake of $100 and 
//a bet of $1 every game

package demo;

import java.util.Random;

//Creating a new public class called Gambler
public class Gambler {
//Defining a constant integer variable called "STARTING_STAKE" with the value 100
final int STARTING_STAKE = 100;
//Defining a constant integer variable called "BET_AMOUNT" with the value 1
final int BET_AMOUNT = 1;
//Defining a constant integer variable called "NUM_GAMES" with the value 100
final int NUM_GAMES = 100;
//Initializing an integer variable called "stake" with the value of "STARTING_STAKE"
int stake = STARTING_STAKE;
//Creating a new instance of the Random class called "rand"
Random rand = new Random();
        
//Defining the main method
public static void main(String[] args) {
 // Creating a new instance of the Gambler class called "gambler"
 Gambler gambler = new Gambler();
 // Calling the "gambler.play()" method
 gambler.play();
}

//Defining a method called "play"
public void play() {
 // Looping through the specified number of games
 for (int i = 1; i <= NUM_GAMES; i++) {
     // Generating a random boolean value called "win" (true for win, false for loss)
     boolean win = rand.nextBoolean();
     // If the player wins
     if (win) {
         // Increasing the stake by the bet amount
         stake += BET_AMOUNT;
         // Printing a message indicating a win and the new stake
         System.out.println("Game " + i + ": Win! New stake is $" + stake);
     } else {
         // Decreasing the stake by the bet amount
         stake -= BET_AMOUNT;
         // Printing a message indicating a loss and the new stake
         System.out.println("Game " + i + ": Loss. New stake is $" + stake);
     }
     // If the player runs out of money
     if (stake <= 0) {
         // Printing a message indicating that the game is over
         System.out.println("Game " + i + ": You're out of money. Game over.");
         // Breaking out of the loop
         break;
     }
 }
}
}
