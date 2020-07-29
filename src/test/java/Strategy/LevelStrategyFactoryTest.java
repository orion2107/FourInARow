package Strategy;

import Strategy.Level.EasyStrategy;
import Strategy.Level.LevelStrategyFactory;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelStrategyFactoryTest {

    @Rule
    LevelStrategyFactory factory= new LevelStrategyFactory();
    EasyStrategy easyStrategy = new EasyStrategy();
    int hard = 2;
    @Test
    void getLevelStrategy() {
        Assertions.assertNotEquals(easyStrategy.getClass(), factory.getLevelStrategy(hard).getClass());
    }
}