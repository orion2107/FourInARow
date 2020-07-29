package Model;

public class Board{
    private int rowSize;
    private int columnSize;
    private int[][] gameBoard; //Game board
    private int numberOfWinningDiscs;

    //---------------------Private Methods----------------------------------
    public Board(int row , int col, int numOfWinningDiscs){
        rowSize = row;
        columnSize = col;
        numberOfWinningDiscs = numOfWinningDiscs;
        gameBoard = new int[rowSize][columnSize];
        resetBoard();
    }

    //---------------------Public Methods-----------------------------------


    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public int getNumberOfWinningDiscs() {
        return numberOfWinningDiscs;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void resetBoard(){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < columnSize; col++){
                gameBoard[row][col] = 0;
            }
        }
    }

    //Getting the exact cell number after the player chose
    //a column to insert
    public int GetRowAfterPlayerMove(int col){
        int i = 0;
        while(i<getRowSize()){
            if(gameBoard[i][col] != 0){
                i++;
            }
            else
                break;
        }
        return i;
    }


    //Maybe can be optimized?
    public boolean BoardIsNotFull(){
        for(int i = 0; i< rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (gameBoard[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    public void setPlayerDisc(int row, int col , int playerId){
        gameBoard[row][col] = playerId;
    }

    public Integer getDiscAtBoard(int row, int col) {
        return gameBoard[row][col];
    }

    public void clearChoice (int row, int col) {
        gameBoard[row][col] = 0;
    }

    public Boolean isEmptyCell (int row, int col) {
        return gameBoard[row][col] == 0;
    }
}

