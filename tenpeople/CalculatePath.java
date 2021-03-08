import java.util.Scanner;


public class CalculatePath {
    
    private int mapSize[] = new int[2];

    private String[][] MAP;

    private Scanner scanner = new Scanner(System.in);

    public final String BINARY = "0";
    public final String DECIMAL = "1";


    public static void main(String args[]) {
        CalculatePath instance = new CalculatePath();  
        instance.run();
    }

    public void run() {
        getMapSize();
        getMapValues();
        getPathsToCheck();
        //testPrintMap();
    }

    public static char getCharFromString(String str, int index) 
    { 
        return str.charAt(index); 
    } 

    private String getInput() {
        String str = scanner.nextLine();
        return str;
    }

    private void init() {
        for (int row = 0; row < mapSize[0]; row++) {
            for (int col = 0; col < mapSize[1]; col++) {
                MAP[row][col] = BINARY;
            }
        }
    }

    private void getMapSize() {

        System.out.println(">>Enter size of map (ex. 2 2 for a 2x2)");

        String str = getInput();
        String splitStr[] = str.trim().split("\\s+");

        for (int i = 0; i < splitStr.length; i++) {
            // System.out.println(splitStr[i] + " - splitStr.");
            mapSize[i] = Integer.parseInt(splitStr[i]);
        }

        // [rows][columns]
        MAP = new String[mapSize[0]][mapSize[1]];
        init();

        System.out.println(">>Nice, map is " + mapSize[0] + " x " + mapSize[1]);

        printMap();
    }

    private void getMapValues() {

        int mapInput[] = new int[mapSize[0] * mapSize[1]];
        String stringInput[] = new String[mapSize[0] * mapSize[1]];

        System.out.println(">>Enter binary map data (only 1:s and 0:s)");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                //System.out.println(in.nextInt());
                for (int i = 0; i < mapInput.length; i++) {
                    mapInput[i] = scanner.nextInt();
                }
            }
            break;
        }

        for (int i = 0; i < mapInput.length; i++) {
            if (mapInput[i] == 0) {
                stringInput[i] = BINARY;
            }
            else if (mapInput[i] == 1) {
                stringInput[i] = DECIMAL;
            }
            else {
                System.out.println("Wrong assignment of peeps! Try again.");
                getMapValues();
            }
        }

        // for (int i = 0; i < stringInput.length; i++) {
        //     System.out.print(stringInput[i]); 
        // }

        System.out.println();

        assignMapValues(stringInput);
    }


    private void assignMapValues(String mapValues[]) {
        int counter = 0;
        for (int row = 0; row < mapSize[0]; row++) {
            for (int col = 0; col < mapSize[1]; col++) {
                MAP[row][col] = mapValues[counter];
                counter++;
            }
        }
        printMap();
    }

    private void printMap() {
        String mapUI = "  ";

        for (int col = 0; col < mapSize[1]; col++) {
            mapUI += col + 1;
            mapUI += " ";
        }

        mapUI += "\n";

        for (int row = 0; row < mapSize[0]; row++) {
            mapUI += row + 1;
            mapUI += " ";
            for (int col = 0; col < mapSize[1]; col++) {
                mapUI += MAP[row][col];
                mapUI += " ";
            }
            mapUI += "\n";
        }

        System.out.println(mapUI);
    }


    private void getPathsToCheck() {
        System.out.println(">>Enter number of paths to check");
        int numOfPaths = scanner.nextInt();

        for (int i = 0; i < numOfPaths; i++) {
            int points[] = new int[4];
            for (int j = 0; j < points.length; j++) {
                points[j] = scanner.nextInt() - 1;
            }
            findPath(points);
        }

    }

    private void findPath(int[] points) {
        // System.out.println(MAP[points[0]][points[1]]);
        // System.out.println(MAP[points[2]][points[3]]);

        if (MAP[points[0]][points[1]] != MAP[points[2]][points[3]]) {
            System.out.println("neither");
            System.out.println("Point 1: " + MAP[points[0]][points[1]]);
            System.out.println("Point 2: " + MAP[points[2]][points[3]]);

        } 
        else {
            bfs.bfsearch(MAP, );
        }
    }

}