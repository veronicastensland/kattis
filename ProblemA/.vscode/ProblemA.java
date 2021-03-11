import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        ProblemA a = new ProblemA();
        a.startProgram();
    }
}

public class ProblemA {

    private Scanner input = new Scanner(System.in);

    private int years;
    private int postcardsThatYear; 

    private int maxPostcards = 100;
    private int maxNameLenght = 20;

    private int uniqueCities[];

    private int tempUniqueCities = 0;
    private List<String> tempUniqueNames = new ArrayList<>();

    public void startProgram() {
        getInput();
        returnOutput();
        Close();
    }

    private void getInput() {
        years = input.nextInt();
        if (years > 50)
            years = 50;
        
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
            postcardsThatYear = input.nextInt();
            if (postcardsThatYear > maxPostcards)
                postcardsThatYear = maxPostcards;

            input.nextLine();

            for (int j = 0; j < postcardsThatYear; j++) {
                String name = getCityName();

                isUniqueName(name);
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

    private void isUniqueName(String name) {
        boolean isInList = tempUniqueNames.contains(name);

        if (!isInList) {
            tempUniqueNames.add(name);
            tempUniqueCities++;
        }
        else {
            return;
        }
    }
}