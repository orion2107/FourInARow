package Strategy.Level;

import Model.Mode.GameLevel;

public class LevelStrategyFactory {
    
    public LevelStrategy getLevelStrategy(int gameLevelInt) {
        GameLevel gameLevel = GameLevel.values()[gameLevelInt];
        LevelStrategy levelStrategy; 
        switch (gameLevel) {
            case Easy: levelStrategy = new EasyStrategy();
                break;
            case Medium: levelStrategy = new MediumStrategy();
                break;
            case Hard: levelStrategy = new HardStrategy();
                break;
            default:
                levelStrategy = new EasyStrategy();
        }
        return levelStrategy;
    }
}
