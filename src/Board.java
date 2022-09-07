import java.util.Objects;

public class Board {
    private char[][] grid;
    public Board(int width){
        if (width <= 2) {
            throw new IllegalArgumentException("Width can't be less than 3");
        }
        //
        this.grid = new char[width][width];
        for (int i = 0; i < grid.length; i++) {
            char []row = grid[i];
            for (int j = 0; j < row.length; j++) {
                row[j] = ' ';
            }
        }
    }

    public boolean setChar(int row, int column, char type){
        /*
        if it returns sucess that means that a valid row, column was inputted, otherwise, an alreadt existing
         spot was inputted
         */
        if (row >= grid.length || column >= grid.length || (type != 'O' && type != 'X')){
            return false;
        }
        if (grid[row][column] != ' '){
            return false;
        }
        // The top left is 0,0 which is kinda wacky but it is like that because each element of the grid starting from zero
        // is actually a row, not a column
        grid[row][column] = type;
        return true;
    }

    /**
     * @param type
     * @return if type of char specified ahs a complete row, diaganol, or column
     */
    public boolean checkWin(char type) {
        // Grid[row][col]
        // Check horizontal win
        boolean horizontalWin = false;
        for (int row = 0; row < grid.length; row++) {
            int occurs = 0;
            for (char c: grid[row]) {
                if (type == c) {
                    occurs++;
                }
            }
            if (occurs == grid.length) {
                return true;
            }
        }

        // Check Vertical Win
        for (int col = 0; col < grid.length; col++){
            for (int row = 0; row < grid.length; row++){
                if (grid[row][col] != type){
                    break;
                } else if (row == grid.length - 1){
                    return true;
                }
            }
        }

        // Check diagnol
        int leftDiagnol = 0, rightDiagnol = 0;
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][row] == type) {
                leftDiagnol++;
            }
            if (grid[grid.length - 1 - row][grid.length - 1 - row] == type) {
                rightDiagnol++;
            }
        }

        return leftDiagnol == grid.length || rightDiagnol == grid.length;
    }

    public boolean checkDraw(){
        // If the whole board if full then the game is a draw (Otherwise it would've checked win). Using the fact that
        for (char[] row: grid){
            for (char box: row){
                if (box == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String output = "";
        for (char [] row: grid) {

            for (char i: row) {
                output += i;
                output += " | ";
            }
            output = output.substring(0, output.length() - 2);
            output += "\n";
            if (grid[grid.length - 1] != row) {
                output += "_".repeat((int)(grid.length * 3.75));
            }
            output += "\n";
        }
        return output;
    }
}
