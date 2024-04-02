package Projects.TicTacToe3.Stratergy.WinningStrategy;

import Projects.TicTacToe3.Model.Board;
import Projects.TicTacToe3.Model.Move;
import Projects.TicTacToe3.Model.Player;

public interface WinningStrategy {
     Player checkWinner(Board board, Move lastMoved);
}
