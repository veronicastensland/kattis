/*
/*
Problem
The problem here is that Onid Pizza wants to know how how much more money they can make if they air their commercial at the right time. 
They want an application where you enter the number of total commercials and the price of each commercial as the first input 
and then the number of students listening to each commercial as the next input. 
The output should be the optimal profit they can make if they choose the right sequence. 
You could think that the output of which sequence is the best could also be a good idea. But no. 
Only the optimal profit is printed. (It would have been a good idea though.)

Solution
My solution consists of the program excpecting input in the form of two ints, the number of commercials and the price of each commercial. 
I then create an array with the lenght of the number of commercials, which will soon contain the profit for each commercial. 
For each int in the array the user inputs the number of students listening to the commercial, and then I withdraw the cost of the commercial 
- which then is the profit (or loss) for that commercial. I then calculate the optimal profit by using Kadane's algorithm for calculating 
the max sum subsequence of the array, and then return the optimal profit that could be made. 


--------- Input -----------  
Input 1: two space separated positive integers N,P 
– the total number of commercial breaks in a day and the price of one commercial break. 
You can assume that N≤100000 and P≤1000.

2: On the next line there are N space-separated integers 
– the i’th integer denotes how many students listen to the i-th commercial break. 
There are always at most 2000 students listening.

--------- Output -----------
Output contains one line with one integer 
– the biggest expected extra profit Onid can get by selecting a continuous sequence of commercial breaks.
*/

import java.util.Scanner;

public class ProblemB {

    private Scanner input = new Scanner(System.in);

    private int optimalProfit;
    private int numOfCommercials;
    private int price;

    private int[] profitPerCommercial;

    public static void main(String[] args) {
        ProblemB problem = new ProblemB();
        problem.run();
    }

    private void run(){
        getData();
        calculateOptimalProfit(profitPerCommercial, numOfCommercials);
        System.out.println(optimalProfit);
    }

    private void getData() {
        numOfCommercials = input.nextInt();
        price = input.nextInt();
        profitPerCommercial = new int[numOfCommercials];

        for (int i = 0; i < profitPerCommercial.length; i++) {
            profitPerCommercial[i] = (input.nextInt() - price);
        }
    }

    // Kadane's algorithm - max sum subsequence
    private void calculateOptimalProfit(int[] arr, int arrSize) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 0; i < arrSize; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxEndingHere < 0) 
                maxEndingHere = 0;
            else if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }

        optimalProfit = maxSoFar;
    }
}
