package Projects.TicTacToe3.Stratergy.WinningStrategy;

import Projects.TicTacToe3.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy {
    private int numberOfPlayers;
    private List<HashMap<Character, Integer>> rowMapList;
    private List<HashMap<Character, Integer>> colMapList;
    private HashMap<Character, Integer> leftDagonalMapList;
    private HashMap<Character, Integer> rightDagonalMapList;
    private HashMap<Character, Integer> cornerMapList;

    public OrderOneWinningStrategy(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        rowMapList = new ArrayList<>();
        colMapList = new ArrayList<>();
        leftDagonalMapList = new HashMap<>();
        rightDagonalMapList = new HashMap<>();
        cornerMapList = new HashMap<>();
        for(int i=0;i<=numberOfPlayers;i++){
            rowMapList.add(new HashMap<>());
            colMapList.add(new HashMap<>());
        }
    }
    @Override
    public Player checkWinner(Board board, Move lastMoved) {
        Player player = lastMoved.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMoved.getCell().getRow();
        int col = lastMoved.getCell().getCol();

        boolean winner =    (checkAndUpdateRowMap(row, player.getSymbol()) ||
                            checkAndUpdateColMap(col,player.getSymbol()) ||
                            (checkLeftDiagonal(row,col) && checkAndUpdateLeftDiagonalMap(player.getSymbol())) ||
                            (checkRightDiagonal(row,col) && checkAndUpdateRightDiagonalMap(player.getSymbol())) ||
                            (checkCorner(row,col) && winnerCheckCorner(board.getMatrix(),player.getSymbol())));
        if(winner)
            return player;
        else
            return null;
    }

    public boolean checkLeftDiagonal(int row, int col){
        return(row == col);
    }

    public boolean checkRightDiagonal(int row, int col){
        return(row+col == numberOfPlayers+1);
    }

    public boolean checkCorner(int row, int col){
        return (row==0 && col == 0 ||
                row==0 && col == numberOfPlayers ||
                row==numberOfPlayers && col ==0 ||
                row==numberOfPlayers && col==numberOfPlayers);
    }


    public boolean winnerCheckCorner(List<List<Cell>> matrix,char symbol){
        return ((matrix.get(0).get(0).getCellStatus() != CellStatus.EMPTY && matrix.get(0).get(0).getPlayer().getSymbol() == symbol) &&
                (matrix.get(0).get(numberOfPlayers).getCellStatus()!= CellStatus.EMPTY && matrix.get(0).get(numberOfPlayers).getPlayer().getSymbol() == symbol )&&
                (matrix.get(numberOfPlayers).get(0).getCellStatus()!= CellStatus.EMPTY && matrix.get(numberOfPlayers).get(0).getPlayer().getSymbol() == symbol )&&
                (matrix.get(numberOfPlayers).get(numberOfPlayers).getCellStatus()!= CellStatus.EMPTY && matrix.get(numberOfPlayers).get(numberOfPlayers).getPlayer().getSymbol() == symbol));
    }

    public boolean checkAndUpdateRowMap(int row, char symbol){
        HashMap<Character,Integer> map= rowMapList.get(row);
        if(map.containsKey(symbol)){
            map.put(symbol,map.get(symbol)+1);
            return map.get(symbol) == numberOfPlayers+1;
        }
        else{
            map.put(symbol,1);
        }
        return false;
    }

    public boolean checkAndUpdateColMap(int row, char symbol){
        HashMap<Character,Integer> map= colMapList.get(row);
        if(map.containsKey(symbol)){
            map.put(symbol,map.get(symbol)+1);
            return map.get(symbol) == numberOfPlayers+1;
        }
        else{
            map.put(symbol,1);
        }
        return false;
    }

    public boolean checkAndUpdateLeftDiagonalMap(char symbol){
        if(leftDagonalMapList.containsKey(symbol)){
            leftDagonalMapList.put(symbol,leftDagonalMapList.get(symbol)+1);
            return leftDagonalMapList.get(symbol) == numberOfPlayers+1;
        }
        else{
            leftDagonalMapList.put(symbol,1);
        }
        return false;
    }

    public boolean checkAndUpdateRightDiagonalMap(char symbol){
        if(rightDagonalMapList.containsKey(symbol)){
            rightDagonalMapList.put(symbol,rightDagonalMapList.get(symbol)+1);
            return rightDagonalMapList.get(symbol) == numberOfPlayers+1;
        }
        else{
            rightDagonalMapList.put(symbol,1);
        }
        return false;
    }
}
