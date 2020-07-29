package Connections;

import Controller.GameManager;
import Events.EventsEnum;
import Events.EventsHandler;
import Events.EventsListener;
import Model.Board;
import Model.GameMenu;
import Model.GameState;
import Model.Mode.GameMode;
import Utils.GameProperties;

import java.util.List;
import java.util.Scanner;

public class TerminalConnection implements /*Observer,*/ EventsListener {
    private GameState gameState;
    Scanner terminalInput;
    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';
    public static char EMPTY = ' ';

    public TerminalConnection() {
        terminalInput = new Scanner(System.in);
    }

    private void registerEvents() {
        EventsHandler eventsHandler = EventsHandler.getInstance();
        eventsHandler.registerEvent(gameState.getGameId(), EventsEnum.PLAYER_MOVED, this);
        eventsHandler.registerEvent(gameState.getGameId(), EventsEnum.GAME_MODE_CHANGED, this);
        eventsHandler.registerEvent(gameState.getGameId(), EventsEnum.WINNER, this);
    }

    public void connectGame(){
        System.out.println("Welcome to Four in a Line!");
        List<String> gameMenu = GameMenu.getInitGameMenu();
        printMenu(gameMenu);
        String choice = terminalInput.nextLine();
        if (choice.equals(GameMenu.QUIT)) {
            printMessage("Bye Bye");
        }else {
            try {
                initGame(Integer.parseInt(choice));
            } catch (NumberFormatException e) {
                printMessage(GameProperties.getPropertyValue("103"));
                connectGame();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                connectGame();
            }
        }
    }

    private void printMenu(List<String> gameMenu) {
        for(String menuItem: gameMenu){
            System.out.println(menuItem);
        }
        System.out.print("Please choose an option:");
    }

    public void initGame(int gameMenuItem) throws Exception {
        gameState = GameManager.getInstance().createNewGame(gameMenuItem);
        if (gameState != null) {
            registerEvents();
            updateBoard();
        }
//        gameState.attach(this);

    }

    private void printWhosNextTurn(int currentPlayer) {
        System.out.print("Player " + currentPlayer + ", choose a column: ");
        if (!gameState.getPlayer(currentPlayer).isComputer()) {
            try {
                int colIndex = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
                colIndex--;
                setPlayerMove(colIndex);
            } catch (NumberFormatException e) {
                printMessage(GameProperties.getPropertyValue("103"));
                printWhosNextTurn(currentPlayer);
            }
        }
    }

    private void printWinner(int currentPlayer) {
        System.out.println("Player " + currentPlayer + " Wins!!!!");
    }

    private void setPlayerMove(int colIndex) {
        try {
            GameManager.getInstance().setPlayerMove(gameState.getGameId(), colIndex);
        } catch (Exception e) {
            printMessage(e.getMessage());
            printWhosNextTurn(gameState.getCurrentPlayer());
        }
    }

    private void printMessage(String errorMsg) {
        System.out.println(errorMsg);
        System.out.println();
    }

    private void printBoard(Board board) {
        System.out.println();
        for (int j = 0; j < board.getRowSize(); j++) {
            System.out.print("|");
            for (int k = 0; k < board.getColumnSize(); k++) {
                char discToPrint;
                switch (board.getDiscAtBoard(j, k)) {
                    case 0: discToPrint = EMPTY; break;
                    case 1: discToPrint = OPLAYER; break;
                    case 2: discToPrint = XPLAYER; break;
                    default:
                        discToPrint = EMPTY;
//                        throw new IllegalStateException("Unexpected value: " + board.getDiscAtBoard(j, k));
                }
                System.out.print(discToPrint + "|");
            }
            System.out.println();
        }
        for (int k = 0; k < 2*board.getColumnSize()+1; k++)
            System.out.print("-");
        System.out.println();
        System.out.println();
    }
//
//    @Override
//    public void update() {
//        printBoard(gameState.getBoard());
//        if (gameState.getWinner()) {
//            printWinner(gameState.getCurrentPlayer());
//        } else {
//            printWhosNextTurn(gameState.getCurrentPlayer());
//        }
//    }

    public void updateBoard() {
        printBoard(gameState.getBoard());
        if (gameState.getWinner()) {
            printWinner(gameState.getCurrentPlayer());
        } else {
            printWhosNextTurn(gameState.getCurrentPlayer());
        }
    }

    public void update(EventsEnum event) {
        switch(event) {
            case QUIT: printMessage(event.getValue()); break;
            case PLAYER_MOVED: updateBoard(); break;
            case WINNER: updateBoard(); break;
        }
    }
}
