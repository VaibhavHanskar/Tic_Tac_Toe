package Projects.TicTacToe3.Model;

import Projects.TicTacToe3.Stratergy.BotPlayingStrategy.BotPlayingStrategy;
import Projects.TicTacToe3.Stratergy.BotPlayingStrategy.BotStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
     public Bot(char symbol, BotDifficultyLevel botDifficultyLevel){
         super("CHITTY",symbol,PlayerType.BOT);
         this.botDifficultyLevel = botDifficultyLevel;
     }

     @Override
     public Move makeMove(Board board){
         return BotStrategyFactory.getBotPLayingStrategy(BotPlayingStrategy.RANDOMBOT).makeMove(board,this);
     }

}
