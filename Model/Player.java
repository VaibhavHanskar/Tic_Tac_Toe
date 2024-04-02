package Projects.TicTacToe3.Model;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType playerType;
    public Player( String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println(getName() + " Enter the row : ");
        int row= sc.nextInt();
        System.out.println(getName() + " Enter the column : ");
        int col= sc.nextInt();
        if(row < 0 || row > board.getNumberOfPlayers() || col < 0 || col>board.getNumberOfPlayers() ){
            makeMove(board);
        }

        Cell playerMoved  = board.getMatrix().get(row).get(col);
        if(playerMoved.getCellStatus() == CellStatus.EMPTY ){
            playerMoved.setCellStatus(CellStatus.FILLED);
            playerMoved.setPlayer(this);
        }
        else {
            makeMove(board);
        }
        return new Move(playerMoved,this);
    }


}
