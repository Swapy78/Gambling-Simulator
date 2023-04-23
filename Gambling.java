/*Java program for simulating the gambling for 20 days and calculating the total
  amount won or lost*/
 

package demo;

public class Gambling {
    private int stake;// declaring a variable to hold the current stake amount
    private int bet;// declaring a variable to hold the amount of bet

 // constructor to initialize the initial stake and bet amount
    public Gambling(int initialStake, int bet) {
        this.stake = initialStake;
        this.bet = bet;
    }
 // method to simulate playing a single round of the game
    public boolean play() {
    	// generating a random number between 0 and 1
        double random = Math.random();
     // if the random number is less than 0.5, the player loses the bet
        if (random < 0.5) {
            stake -= bet;// reducing the stake by the bet amount
            return false;// returning false to indicate loss
// if the random number is greater than or equal to 0.5, the player wins the bet
        } else { 
            stake += bet;// increasing the stake by the bet amount
            return true;// returning true to indicate win
        }
    }
 // method to get the current stake amount
    public int getStake() {
        return stake;
    }
 // main method to simulate playing the game over several days
    public static void main(String[] args) {
        int initialStake = 100;// setting the initial stake to 100
        int bet = 1;// setting the bet amount to 1
        int days = 20;// setting the number of days to simulate playing the game

     // variable to hold the total amount won/lost over all the days
        int totalAmount = 0;
        // looping over each day
        for (int i = 0; i < days; i++) {
        	// looping over each round of the game
            Gambling gambler = new Gambling(initialStake, bet);
            while (gambler.getStake() > 0 && gambler.getStake() < 200) {
                boolean won = gambler.play();
             // checking if the player has won enough to stop playing for the day
                if (won && gambler.getStake() >= 150) {
                    break;// breaking out of the loop
           // checking if the player has lost enough to stop playing for the day
                } else if (!won && gambler.getStake() <= 50) {
                    break;// breaking out of the loop
                }
            }
         // calculating the amount won/lost for the day
            int amount = gambler.getStake() - initialStake;
         // printing the amount won/lost for the day
            System.out.printf("Day %d: %s%d\n", i + 1, amount >= 0 ? "+" : "", amount);
            totalAmount += amount;// adding the amount won/lost to the total amount
        }

        System.out.printf("Total amount won/lost: %s%d\n", totalAmount >= 0 ? "+" : "", totalAmount);
    }
}
