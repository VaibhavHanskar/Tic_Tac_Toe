package Projects.TicTacToe3.Stratergy.BotPlayingStrategy;

import Projects.TicTacToe3.Model.Board;
import Projects.TicTacToe3.Model.Move;
import Projects.TicTacToe3.Model.Player;

public interface BotStrategy {
    Move makeMove(Board board, Player player);
}
