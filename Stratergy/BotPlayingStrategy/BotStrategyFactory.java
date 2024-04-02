package Projects.TicTacToe3.Stratergy.BotPlayingStrategy;

public class BotStrategyFactory {
    public static BotStrategy getBotPLayingStrategy(BotPlayingStrategy name){
        switch (name){
            case RANDOMBOT:return new RandomBotPlayingStrategy();
        }
        return null;
    }
}
