package Projects.TicTacToe3.Exception;

public class GameOverException extends RuntimeException{
    public GameOverException(){
        System.out.println("Game is Over");
    }
}
