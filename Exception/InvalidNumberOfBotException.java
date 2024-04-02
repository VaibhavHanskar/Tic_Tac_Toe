package Projects.TicTacToe3.Exception;

public class InvalidNumberOfBotException extends RuntimeException{
    public InvalidNumberOfBotException(){
        System.out.println("Number of bots are invalid");
    }
}
