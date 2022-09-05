import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    public void play(){
        // To do:
        // - If they put another persons spot, they get infinite chances
        // - If they go out of bounds they get infinite
        // - Better out of bound handeling
        // Future - Bot playing
        // Creating Scanner object
        Scanner inputReader = new Scanner(System.in);
        // Telling the rules
        System.out.println("Get all of the diagonals in your shape or any row or column in your color to win. The " +
                "top left is (0, 0) and it increases to the bottom right. Have fun!!");
        // Board Size Question
        int width = readInt("width of board: ", inputReader);
        Board board = new Board(width);
        // Game Loop
        /*
        1. Ask player 1 for the column number and row number
        2. show the board
            2.1 Check win, if win, then break and display who won
            2.2 Check draw, if draw, then break and display draw
        3. Ask player 2 for column number and row number
            3.1 Check win, if win, then break and display who won
            3.2 Check draw, if draw, then break and display draw
        4. show the board
         */
        // IMPORTANT: CHECK WIN BEFORE CHECK DRAW BECAUSE CHECK DRAW JUST SAYS IF THE BOARD IS FULL
        boolean xWin;
        boolean oWin;
        System.out.println(board);
        while (!Objects.equals(readStringLine("exit??? ", inputReader), "yes")) {
            // Player One's turn
            board.setChar(readInt("X Row Number: ", inputReader), readInt("X Column Number: ", inputReader), 'X');
            System.out.println(board);
            // X can only win on their turn and the same for O, so putting oWin in uneccesary
            xWin = board.checkWin('X');
            if (xWin) {
                System.out.println("Congrats! X won");
                break;
            } else if (board.checkDraw()){
                System.out.println("This is a draw");
                break;
            }
            // Player O's turn
            board.setChar(readInt("O Row Number: ", inputReader), readInt("O Column Number: ", inputReader), 'O');
            System.out.println(board.toString());
            oWin = board.checkWin('O');
            if (oWin) {
                System.out.println("Congrats! O won");
                break;
            } else if (board.checkDraw()){
                System.out.println("This is a draw");
                break;
            }
        }
    }


    // Method for reading a string input
    public static String readStringLine(String prompt, Scanner scantron){
        System.out.print(prompt);
        return scantron.next();
    }

    // Method for reading an integer input
    public static int readInt(String prompt, Scanner scantron){
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scantron.nextInt();
                return input;
            } catch (InputMismatchException exception) {
                // Does nothing
                scantron.next();
            }
        }
    }
}
