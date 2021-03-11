import java.util.Scanner;


public class Program {
    
    private int mapSize[] = new int[2];
    private int[][] MAP;

    private Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        Program instance = new Program();  
        instance.run();
    }

    public void run() {
        getMapSize();
        getMapValues();
        getPathsToCheck();
    }

    private void init() {
        for (int row = 0; row < mapSize[0]; row++) {
            for (int col = 0; col < mapSize[1]; col++) {
                MAP[row][col] = 0;
            }
        }
    }

    private String getInput() {
        String str = scanner.nextLine();
        return str;
    }

    private void getMapSize() {

        System.out.println(">>Enter size of map (ex. 2 2 for a 2x2)");
        mapSize[0] = scanner.nextInt();
        mapSize[1] = scanner.nextInt();
        
        MAP = new int[mapSize[0]][mapSize[1]];

        // init();
        System.out.println(">>Map is " + mapSize[0] + " x " + mapSize[1]);
        // printMap();
    }

    private void getMapValues() {
        int mapInput[] = new int[mapSize[0] * mapSize[1]];

        System.out.println(">>Enter binary map data (only 1:s and 0:s)");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                for (int i = 0; i < mapInput.length; i++) {
                    mapInput[i] = scanner.nextInt();
                }
            }
            break;
        }

        assignMapValues(mapInput);
    }


    private void assignMapValues(int mapValues[]) {
        int counter = 0;

        for (int row = 0; row < mapSize[0]; row++) {
            for (int col = 0; col < mapSize[1]; col++) {
                MAP[row][col] = mapValues[counter];
                counter++;
            }
        }

        // System.out.println("HEYY" + MAP.length);
        // System.out.println("HEYY!!!!" + MAP[0].length);

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
                if (points[j] < 0)
                    points[j] = 0;
            }
            findPath(points);
        }

    }

    private void findPath(int[] points) {
        if (points[0] == points[2] && points[1] == points[3]) {
            if (MAP[points[0]][points[1]] == 0) 
                System.out.println("binary same coordinates");
            else
                System.out.println("decimal same coordinates");

            return;
        }

        if (MAP[points[0]][points[1]] != MAP[points[2]][points[3]]) {
            System.out.println("neither first");
            // System.out.println("Point 1: " + MAP[points[0]][points[1]]);
            // System.out.println("Point 2: " + MAP[points[2]][points[3]]);
        } 
        else {
            bfs.bfsearch(MAP, mapSize[0], mapSize[1], points); 
        }
    }

}