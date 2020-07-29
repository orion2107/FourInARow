package View;
import Model.Board;

public class TerminalViewer implements ViewerInterface {

    public void display(Board board) {
        System.out.println("Printing board:");
        System.out.println();
        for(int row = 0 ; row < board.getRowSize(); row++){
            System.out.print("|");
            for(int col = 0 ; col < board.getColumnSize(); col++){
                System.out.print(board.getGameBoard()[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
