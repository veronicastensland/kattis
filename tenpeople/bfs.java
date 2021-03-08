import java.util.PriorityQueue;
import java.util.Queue;

public class bfs {

    public static boolean bfsearch(String[][] map, int rows, int cols, int[] path) {

        // int[][] start = new int[path[0]][path[1]];
        // int[][] end = new int[path[2]][path[3]];

        int[] start = {path[0], path[1]};
        int[] end = {path[2], path[3]};
        
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new PriorityQueue<>();

        queue.add(start); // lägger till startnoden i kön
        visited[path[0]][path[1]] = true; // sätter visited till true

        // lägg till startnodens grannar i kön (a och b)
        // ta bort startnoden ut kön
        // sätt nod a till true
        // lägg till a:s grannar i kön
        // ta bort a ur kön



        return false;
    }
    
}
