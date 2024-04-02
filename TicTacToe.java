package Projects.TicTacToe3;

import Projects.TicTacToe3.Controller.GameController;
import Projects.TicTacToe3.Model.*;
import Projects.TicTacToe3.Stratergy.WinningStrategy.WinningStrategyName;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        String ch = "Y";
        do {
            GameController gameController = new GameController();
            Scanner sc = new Scanner(System.in);
            List<Player> players = new ArrayList<>();
            System.out.println("Enter the number of players: ");
            int numberOfPlayers = sc.nextInt();
            System.out.println("Do you want bot : (Y/N)");
            String botRequired = sc.next();
            int i=0;
            if (botRequired.equalsIgnoreCase("Y") || numberOfPlayers == 1) {
                System.out.println("Bot Symbol : ");
                char botSymbol = sc.next().charAt(0);
                System.out.println("1) EASY \n2) MEDIUM \n3) HARD");
                System.out.println("Select Bot Difficulty level(Enter the Number) : ");
                int difficultyLevel = sc.nextInt();
                Player bot = null;
                switch (difficultyLevel) {
                    case 1:
                        bot = new Bot(botSymbol, BotDifficultyLevel.EASY);
                    case 2:
                        bot = new Bot(botSymbol, BotDifficultyLevel.MEDIUM);
                    case 3:
                        bot = new Bot(botSymbol, BotDifficultyLevel.HARD);
                }
                numberOfPlayers += 1;
                players.add(bot);
                i++;
            }
            while (i < numberOfPlayers) {
                System.out.println("Enter Player Name : ");
                String playerName = sc.next();
                System.out.println("Enter Player Symbol : ");
                char playerSymbol = sc.next().charAt(0);
                Player player = new Player(playerName, playerSymbol, PlayerType.HUMAN);
                players.add(player);
                i++;
            }
            Collections.shuffle(players);
            Game game = gameController.createGame(numberOfPlayers, players, WinningStrategyName.ORDERONEWINNING);
            int playerIndex = -1;
            while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
                System.out.println("Current board status");
                gameController.displayBoard(game);
                playerIndex++;
                playerIndex = playerIndex % numberOfPlayers;
                Move movePlayed = gameController.executeMove(game, players.get(playerIndex));
                game.getMoves().add(movePlayed);
                game.getBoardStates().add(game.getCurrentBoard());
                Player winner = gameController.checkWinner(game, movePlayed);
                if (winner != null) {
                    System.out.println("Winner is " + winner.getName());
                    break;
                }
                if (game.getMoves().size() == (game.getCurrentBoard().getNumberOfPlayers() + 1) * (game.getCurrentBoard().getNumberOfPlayers() + 1)) {
                    System.out.println("Game is DRAW");
                    break;
                }
            }
            System.out.println("Final Board Status");
            gameController.displayBoard(game);
            System.out.println("Do you want to play again : Y/N");
            ch = sc.next().toUpperCase();
        } while (ch.charAt(0) == 'Y');
    }
}
