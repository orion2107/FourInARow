

import Connections.TerminalConnection;
import Controller.GameManager;
import Dao.RamGameDao;

public class Main {
    public static void main(String[] args) {

        GameManager gameManager = GameManager.getInstance();
        gameManager.getGameProxyDao().setCurrentDao(new RamGameDao());
        TerminalConnection terminalConnection = new TerminalConnection();
        terminalConnection.connectGame();

    }
}
