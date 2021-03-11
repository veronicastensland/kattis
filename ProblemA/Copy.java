import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Copy {


// Ska ta emot en int T som beskriver hur många år man ska titta tillbaka på
// Tar emot en int n som står för antalet postcards det året
// Följt av n många stadsnamn

// for (int i = 0; i < T; i++) 


    private Scanner input = new Scanner(System.in);

    private int years; // years
    private int amountThatYear; // number of postcards

    private int maxPostcards = 100;
    private int maxCityChar = 20;

    private int tempUniqueCities = 0;
    private int uniqueCities[];

    private List<String> tempUniqueNames = new ArrayList<>();

    public static void main(String args[]) {
        Copy a = new Copy();
        a.getInput();
        a.returnOutput();
        a.Close();
    }

    public void getInput() {
        //System.out.println("Enter years");
        years = input.nextInt();
        loopOverPostcards();
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
        uniqueCities = new int[years];

        for (int i = 0; i < years; i++) {
            //System.out.println("Enter number of postcards");
            amountThatYear = input.nextInt();
            input.nextLine();


            for (int j = 0; j < amountThatYear; j++) {
                //System.out.println("Enter name");
                String name = getCityName();

                isUniqueName(name);
            }
            uniqueCities[i] = tempUniqueCities;
            //print();
            tempUniqueCities = 0;
            tempUniqueNames.clear();
        }
    }

    public String getCityName() {
        //System.out.println("Enter name");
        String cityName = input.nextLine();
        
        return cityName;
    }

    private void isUniqueName(String name) {
        boolean isInList = tempUniqueNames.contains(name);

        if (!isInList) {
            tempUniqueNames.add(name);
            tempUniqueCities++;
            //System.out.println("The list did not contain " + name); 
        }
        else {
            //System.out.println("The list contained " + name); 
        }
    }

    // private void print() {
    //     System.out.println(tempUniqueCities + " unique names:");
    //     System.out.println(tempUniqueNames);
    // }

}
