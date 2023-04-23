/*Java program that allows a user to continue or stop gambling based on whether
  they won or lost in the current month */


package demo;

import java.util.Scanner;

public class GamblingProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initializing variables to keep track of total winnings and losses
        int totalWon = 0, totalLost = 0;
        boolean continueGambling = true;
        int currentMonth = 1;

        // Looping to continue gambling each month until the user chooses to stop
        while (continueGambling) {
            // Initializing variables for the current month's winnings and losses
            int monthWon = 0, monthLost = 0;
            int stake = 100;
            
            // Looping to simulate gambling for each day of the month
            for (int day = 1; day <= 30; day++) {
                // Simulating a win or loss for the day
                int result = (int) Math.round(Math.random());
                if (result == 1) {
                    stake++;
                    monthWon++;
                } else {
                    stake--;
                    monthLost++;
                }
                
                // Exiting the loop if stake falls below 50 or goes above 150
                if (stake <= 50 || stake >= 150) {
                    break;
                }
            }
            
            // Printing the month's report
            System.out.println("Month " + currentMonth + " report:");
            System.out.println("Days won: " + monthWon + ", Days lost: " + monthLost);
            System.out.println("Total amount won: $" + (monthWon - monthLost));
            System.out.println();

            // Updating total winnings and losses
            totalWon += monthWon;
            totalLost += monthLost;

            // Asking user if they want to continue gambling next month
            System.out.println("Do you want to continue gambling next month? (yes or no)");
            String choice = sc.nextLine();
            if (choice.equals("no")) {
                continueGambling = false;
            }
            currentMonth++;
        }
        
        // Printing total winnings and losses
        System.out.println("Total days won: " + totalWon + ", Total days lost: " + totalLost);
        System.out.println("Total amount won: $" + (totalWon - totalLost));
        
        // Closing scanner object
        sc.close();
    }
}
