import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView {
    JFrame frame;
    private JButton[][] buttons;
    private JButton quitButton;
    private JTextArea statusArea;

    public GameView() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500); // Increased height for the Quit button
        frame.setLayout(new BorderLayout());

        buttons = new JButton[3][3];
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new TTTTileButton(i, j);
                buttonPanel.add(buttons[i][j]);
            }
        }

        // Add the Quit button
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font for the Quit button
        quitButton.setPreferredSize(new Dimension(100, 50)); // Adjust the size of the Quit button

        statusArea = new JTextArea();
        statusArea.setEditable(false);
        statusArea.setFont(new Font("Arial", Font.BOLD, 16)); // Font for status area

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(quitButton, BorderLayout.SOUTH); // Add Quit button to the bottom
        frame.add(statusArea, BorderLayout.NORTH); // Place status area above the buttons
    }

    public void setButtonActionListener(ActionListener listener) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].addActionListener(listener);
            }
        }
    }

    public void setQuitButtonActionListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }

    public void updateButton(int row, int col, char marker) {
        buttons[row][col].setText(String.valueOf(marker));
    }

    public void setStatusMessage(String message) {
        statusArea.setText(message);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void resetButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(" ");
            }
        }
    }

    public void close() {
        frame.dispose();
    }
}
