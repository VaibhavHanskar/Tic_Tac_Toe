package Projects.TicTacToe3.Controller;

import Projects.TicTacToe3.Model.*;
import Projects.TicTacToe3.Stratergy.WinningStrategy.WinningStrategy;
import Projects.TicTacToe3.Stratergy.WinningStrategy.WinningStrategyFactory;
import Projects.TicTacToe3.Stratergy.WinningStrategy.WinningStrategyName;

import java.util.List;

public class GameController {
    public Game createGame(int numberOfPlayers, List<Player> players, WinningStrategyName name){
        return Game.builder()
                .setNumberOfPlayers(numberOfPlayers)
                .setPlayers(players)
                .setWinningStratergy(WinningStrategyFactory.getWinningStrategy(name,numberOfPlayers))
                .build();
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public GameStatus getGameSatus(Game game){
        return game.getGameStatus();
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game, Move lastMoved){
        return game.getWinningStratergy().checkWinner(game.getCurrentBoard(),lastMoved);
    }

    public Move undoMove(Game game, Move lastMoved){
        return null;
    }

    public void replayGame(){
        return;
    }
}
