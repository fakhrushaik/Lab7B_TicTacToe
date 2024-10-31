public class Run {
    public static void main(String[] args) {
        Game game = new Game();
        GameView view = new GameView();
        GameController controller = new GameController(game, view);

        view.display();
        view.setStatusMessage("Current Turn: " + game.getCurrentPlayer().getName());
    }
}
