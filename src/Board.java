import java.util.Objects;

public class Board {
    private char[][] grid;
    private boolean player;
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
        player = false;
    }

    public String setChar(int row, int column, char type){
        /*
        if it returns sucess that means that a valid row, column was inputted, otherwise, an alreadt existing
         spot was inputted
         */
        if (row >= grid.length || column >= grid.length || (type != 'O' && type != 'X')){
            throw new IllegalArgumentException("the position is too high or you inputted the wrong character");
        }
        // The top left is 0,0 which is kinda wacky but it is like that because each element of the grid starting from zero
        // is actually a row, not a column
        grid[row][column] = type;
        return "Success";
    }

    public boolean checkWin(char type) {
        // This clunky piece checks for horizontal, vertical, or diagnol wins by using the same iterator to represent
        // different things
        boolean upDiagonal = true;
        boolean downDiagonal = true;
        for (int i = 0; i < grid.length; i++) {
            // Check vertical win
            // Check each element in the column to see if it is the type wanted
            // grid[a][b] -> a is the row from the top, b is the column from the top
            // if checking for a vertical win, then a should be changing and b should be constant
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != type) {
                    break;
                    // breaks and goes to the next column
                } else if (i == grid.length - 1) {
                    // if it reaches the end of the column it is true
                    return true;
                }
            }
            // Check horizontal win
            // Check each element in the column to see if it is the type wanted
            // If chekcing for a horizontal win then grid[b] should be changing
            for (int k = 0; k < grid.length; k++) {
                if (grid[i][k] != type) {
                    break;
                    // breaks and goes to the next row
                } else if (k == grid.length - 1) {
                    // if it reaches the end of the row it is true
                    return true;
                }
            }
            // Check down diagonal
            if (grid[i][i] != type) {
                upDiagonal = false;
            }
            // Check up diagonal
            if (grid[i][grid.length - 1 - i] != type){
                downDiagonal = false;
            }
        }
        if (upDiagonal){
            System.out.println("up diagnol victory royale");
        }
        if (downDiagonal){
            System.out.println("down diagnol victory royale");
        }
        return upDiagonal || downDiagonal;
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
