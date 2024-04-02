package Projects.TicTacToe3.Model;



import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> matrix;
    private int numberOfPlayers;

    public Board(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        matrix = new ArrayList<>();
        for(int i=0;i<=numberOfPlayers;i++){
            matrix.add(new ArrayList<>());
            for(int j=0;j<=numberOfPlayers;j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<=numberOfPlayers;i++){
            List<Cell> cells = matrix.get(i);
            for(Cell cell : cells){
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
