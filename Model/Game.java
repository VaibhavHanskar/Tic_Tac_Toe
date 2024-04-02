package Projects.TicTacToe3.Model;


import Projects.TicTacToe3.Exception.InvalidNumberOfBotException;
import Projects.TicTacToe3.Exception.InvalidNumberOfSymbolException;
import Projects.TicTacToe3.Stratergy.WinningStrategy.WinningStrategy;
import Projects.TicTacToe3.Stratergy.WinningStrategy.WinningStrategyFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Board> boardStates;
    private Board currentBoard;
    private List<Player> players;
    private List<Move> moves;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private int numberOfSymbols;
    private WinningStrategy winningStrategy;

    private Game( Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.boardStates = new ArrayList<>();
        this.currentBoard = currentBoard;
        this.players = players;
        this.moves = new ArrayList<>();
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.numberOfSymbols = players.size();
        this.winningStrategy = winningStrategy;
    }

    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public WinningStrategy getWinningStratergy() {
        return winningStrategy;
    }

    public void setWinningStratergy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static class GameBuilder{
        private int numberOfPlayers;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public GameBuilder setNumberOfPlayers(int numberOfPlayers) {
            this.numberOfPlayers = numberOfPlayers;
            return this;
        }

        public GameBuilder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStratergy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validBot(){
            int botCount =0;
            for(int i=0;i<numberOfPlayers;i++){
                if(players.get(i).getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount > 1 || botCount<0){
                throw new InvalidNumberOfBotException();
            }
        }

        public void validSymbol(){
            HashSet<Character> set = new HashSet<>();
            for(int i=0;i<numberOfPlayers;i++){
                set.add(players.get(i).getSymbol());
            }
            if(set.size() != numberOfPlayers){
                throw new InvalidNumberOfSymbolException();
            }
        }
        public void validate(){
            validBot();
            validSymbol();
        }
        public Game build(){
            validate();
            return new Game(new Board(numberOfPlayers),players, winningStrategy);
        }
    }
}
