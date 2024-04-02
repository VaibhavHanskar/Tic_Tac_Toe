package Projects.TicTacToe3.Stratergy.BotPlayingStrategy;

import Projects.TicTacToe3.Exception.GameOverException;
import Projects.TicTacToe3.Model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotStrategy{
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> matrix = board.getMatrix();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.size();j++){
                if(matrix.get(i).get(j).getCellStatus() == CellStatus.EMPTY){
                    matrix.get(i).get(j).setPlayer(player);
                    matrix.get(i).get(j).setCellStatus(CellStatus.FILLED);
                    return new Move(board.getMatrix().get(i).get(j),player);
                }
            }
        }
        throw new GameOverException();
    }
}
