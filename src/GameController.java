import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GameController {
    private Game game;
    private GameView view;

    public GameController(Game game, GameView view) {
        this.game = game;
        this.view = view;

        view.setButtonActionListener(new ButtonClickListener());
        view.setQuitButtonActionListener(new QuitButtonListener());
    }

    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TTTTileButton button = (TTTTileButton) e.getSource();
            int row = button.getRow();
            int col = button.getCol();
            Player currentPlayer = game.getCurrentPlayer();

            if (game.getBoard().makeMove(row, col, currentPlayer.getMarker())) {
                view.updateButton(row, col, currentPlayer.getMarker());
                if (game.getBoard().checkWinCondition(currentPlayer.getMarker())) {
                    view.setStatusMessage(currentPlayer.getName() + " wins!");
                    int response = JOptionPane.showConfirmDialog(view.frame,
                            "Game Over! " + currentPlayer.getName() + " wins! Would you like to play again?",
                            "Game Over",
                            JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        resetGame();
                    } else {
                        view.close(); // Close the application
                    }
                    return;
                }
                game.switchPlayer();
                view.setStatusMessage("Current Turn: " + game.getCurrentPlayer().getName());
            }
        }
    }

    class QuitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(view.frame,
                    "Are you sure you want to quit?",
                    "Confirm Quit",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                view.close();
            }
        }
    }

    private void resetGame() {
        game.getBoard().resetBoard();
        view.resetButtons();
        game.switchPlayer();
        view.setStatusMessage("Current Turn: " + game.getCurrentPlayer().getName());
    }
}
