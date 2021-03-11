import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



public class bfs {

    static boolean isValid(boolean visitedAlready[][], int row, int col, int totalRows, int totalCols) {
        if (row < 0 || col < 0 || row >= totalRows || col >= totalCols)
            return false;

        if (visitedAlready[row][col])
            return false;
        
        return true;
    }

    public static void bfsearch(int[][] map, int rows, int cols, int[] path) {
        System.out.println("Starting BFS...");
        
        int h = map.length;
        if (h == 0) 
            return;
        int l = map[0].length;



        int walkable = map[path[0]][path[1]];
        
        boolean[][] visited = new boolean[rows][cols];
        Queue<pair> queue = new LinkedList<>();

        queue.add(new pair()); 
        visited[path[0]][path[1]] = true; 

        while (!queue.isEmpty()) {
            String x = queue.remove();
            int xRow = Integer.parseInt(x.split(",")[0]);
            int xCol = Integer.parseInt(x.split(",")[1]);

            System.out.println("xRow = " + xRow + " and xCol = " + xCol);

            if (isValid(visited, xRow, xCol, rows, cols)) {
                System.out.print(map[xRow][xCol] + " - walkable");
                visited[xRow][xCol] = true;

                queue.add(xRow + "," + (xCol - 1)); // left
                queue.add(xRow + "," + (xCol + 1)); // right
                queue.add((xRow - 1) + "," + (xCol)); // up
                queue.add((xRow + 1) + "," + (xCol)); // down
            }
        }

        if (visited[path[2]][path[3]]) {
            if (walkable == 0) 
                System.out.println("binary");
                // return "binary";
            else 
                System.out.println("decimal");
                // return "decimal";
        } 
        else
            System.out.println("neither");
            // return "neither";
    }
    
}

class pair {

    int first, second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
