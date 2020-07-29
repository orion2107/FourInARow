package Strategy.GameStrategy;

import Model.Mode.GameMode;

public class GameStrategyFactory {

    public GameStrategy getGameStrategy(GameMode gameMode) {
        GameStrategy gameStrategy;
        switch (gameMode) {
            case PlayerVsComp: gameStrategy = new PlayerVsComputerStrategy();
                break;
            case PlayerVsPlayer: gameStrategy = new PlayerVsPlayerStrategy();
                break;
//            case ComputerVsComputer: gameStrategy = new ComputerVsComputerStrategy();
//                break;
            default:
                gameStrategy = new PlayerVsComputerStrategy();
        }
        return gameStrategy;
    }
}

