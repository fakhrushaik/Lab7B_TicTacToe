import javax.swing.*;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        playerX = new Player("Player X", 'X');
        playerO = new Player("Player O", 'O');
        currentPlayer = playerX;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void startGame() {
        // Logic to reset the game can be added here
    }
}
