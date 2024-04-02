package Projects.TicTacToe3.Stratergy.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategyName name, int numberOfPlayers){
        switch (name){
            case ORDERONEWINNING:
                return new OrderOneWinningStrategy(numberOfPlayers);
        }
        return null;
    }
}
