package Projects.TicTacToe3.Exception;

public class InvalidNumberOfSymbolException extends RuntimeException{
    public InvalidNumberOfSymbolException(){
        System.out.println("Number of Symbols are invalid");
    }
}
