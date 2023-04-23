/*Java program that keeps track of the number of days won and lost in a month
 and calculates the total amount won or lost*/
 

package demo;

import java.util.Random;

public class MonthlyGambler {
	 private int stake; // the amount of money the gambler currently has
	    private int bet;  // the amount of money the gambler bets on each game
	    private int daysWon;  // number of days won by the gambler in a month
	    private int daysLost; // number of days lost by the gambler in a month
	    private int totalWin; // total amount won/lost by the gambler in a month

	// constructor to initialize stake and bet
    public MonthlyGambler(int stake, int bet) {
        this.stake = stake;
        this.bet = bet;
    }
 // method to simulate the gambler's gameplay for one month
    public void playMonth() {
        daysWon = 0;
        daysLost = 0;
        totalWin = 0;

        // looping for 30 days
        for (int i = 1; i <= 30; i++) {
            int result = playDay();
            if (result > 0) {
                daysWon++;
            } else {
                daysLost++;
            }
            totalWin += result;
        }
    }
 // method to simulate the gambler's gameplay for one day
    private int playDay() {
        int wins = 0;
        int losses = 0;
     // creating a random object to simulate game outcomes
        Random rand = new Random();

     // looping until the gambler wins $200 or runs out of money
        while (stake > 0 && stake < 200) {
        	boolean win = rand.nextBoolean(); //simulating a game outcome (win or lose)
            if (win) {
                stake += bet; // increasing the gambler's stake by the bet amount if they win
                wins++;  // incrementing the number of wins for this day
            } else {
                stake -= bet; // decreasing the gambler's stake by the bet amount if they lose
                losses++; // incrementing the number of losses for this day
            }
        }
// returning the result of the day (-bet * losses if the gambler lost, or bet * wins if they won)
        if (stake == 200) {
            return wins * bet;
        } else {
            return -losses * bet;
        }
    }
 // getters for daysWon, daysLost, and totalWin
    public int getDaysWon() {
        return daysWon;
    }

    public int getDaysLost() {
        return daysLost;
    }

    public int getTotalWin() {
        return totalWin;
    }
 // main method to run the simulation
    public static void main(String[] args) {
        MonthlyGambler gambler = new MonthlyGambler(100, 1);
        gambler.playMonth();
        System.out.println("Days won: " + gambler.getDaysWon());
        System.out.println("Days lost: " + gambler.getDaysLost());
        System.out.println("Total win/loss: $" + gambler.getTotalWin());
    }
}

