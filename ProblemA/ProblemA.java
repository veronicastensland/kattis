/*
---------- Problem -------------
The problem is that Kattis want to be able to present a pile of postcards basically, 
and then have the program count how many unique citites the postcards are from and only print out the number of unique cities. 

If we only want to investigate one year, and If there are 8 cards from Chicago, 
2 cards from Gothenburg and 5 cards from Paris, then the number of unique cities is 3 and that is what the output should be.

---------- Solution -------------
My solution was pretty straightforward. In the method loopOverPostcards() I ask for the input of how many years to be investigated, 
and then create an array the size of the number of years to be able to store an int of unique city-names for every year. 

For every year, I ask for the input of postcrads recieved that year, and then proceed to loop for the amount of postcards revieved. 
Here I get the input of the city-name, check if its a unique name and if it is: I store the name in a temporary list and increment 
a temporary int to store the number of unique names. 

It will continue to do so until all the postcards are checked, and as soon as it jumps out of the inner for-loop it saves the 
number of unique namnes in the final int to be printed, and then clear the temporary files in case there are more years to be investigated. 
If there are more years, the program will start over from my second paragraph, but if not it will print out the result. 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    private Scanner input = new Scanner(System.in);

    private int years;
    private int postcardsThatYear; 

    private final int maxPostcards = 100;
    private final int maxNameLenght = 20;

    private int uniqueCities[];

    private int tempUniqueCities = 0;
    private List<String> tempUniqueNames = new ArrayList<>();

    public static void main(String args[]) {
        ProblemA a = new ProblemA();
        a.runProgram();
        a.Close();
    }

    public void runProgram() {
        loopOverPostcards();
        returnOutput();
    }

    private void returnOutput() {
        for (int i = 0; i < uniqueCities.length; i++) {
            System.out.println(uniqueCities[i]);
        }
    }

    private void Close() {
        System.exit(0); 
    }

    private void loopOverPostcards() {

        years = input.nextInt();
        if (years > 50)
            years = 50;

        uniqueCities = new int[years];

        for (int i = 0; i < years; i++) {
            postcardsThatYear = input.nextInt();
            if (postcardsThatYear > maxPostcards)
                postcardsThatYear = maxPostcards;

            input.nextLine();

            for (int j = 0; j < postcardsThatYear; j++) {
                String name = getCityName();

                if (isUniqueName(name)){
                    tempUniqueNames.add(name);
                    tempUniqueCities++;
                }
            }

            uniqueCities[i] = tempUniqueCities;

            tempUniqueCities = 0;
            tempUniqueNames.clear();
        }
    }

    public String getCityName() {
        String cityName = input.nextLine();

        if (cityName.length()>maxNameLenght) {
            String cutName = cityName.substring(0, 20);
            cityName = cutName;
        }

        return cityName;
    }

    private boolean isUniqueName(String name) {
        boolean isInList = tempUniqueNames.contains(name);

        if (!isInList)
            return true;
        else 
            return false;
    }
}