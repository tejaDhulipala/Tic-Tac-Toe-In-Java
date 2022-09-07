import java.lang.reflect.Array;
import java.util.ArrayList;

public class TTTBot{
    public TTTBot(){
        ;
    }

    public static ArrayList<int[]> getPossibleMoves(char[][] grid){
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid.length; col++){
                if (grid[row][col] == ' '){
                    int[] pos = {row, col};
                    possibleMoves.add(possibleMoves.size() - 1, pos);
                }
            }
        }
        return  possibleMoves;
    }

    public static void createGameMap(char[][] startingGrid){
        // WIP
    }
}
