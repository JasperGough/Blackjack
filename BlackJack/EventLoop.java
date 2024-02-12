public class EventLoop
{
    State state = new State();
    UI ui = new UI();
    
    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        eventLoop.run();
    }
    public void run() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                state.setPlayerTotal(state.getPlayerTotal() * -1);
                state.setDealerTotal(state.getDealerTotal() * -1);
                state.setGameState(Constants.GET_NAME);
            } else if (gameState == Constants.GET_NAME) {
                state.setPlayerName(ui.promptForName());
                state.setGameState(Constants.GET_SHUFFLE);
            } else if (gameState == Constants.GET_SHUFFLE) {
                if (ui.getShuffle()) {
                    state.shuffleDeck();
                    ui.printDeckShuffled();
                }
                state.setGameState(Constants.START_GAME);
            } else if (gameState == Constants.START_GAME) {
                ui.printGameStart();
                try
                {
                    Thread.sleep(Constants.DELAY);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                for (int i = 0; i < 2; i++) {
                    state.drawCard();
                    state.setPlayerTotal(state.getCurrentCard());
                    ui.printMove(state);
                    try
                    {
                        Thread.sleep(Constants.DELAY);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                state.setGameState(Constants.GET_PLAYER_MOVE);
            } else if (gameState == Constants.GET_PLAYER_MOVE) {
                if (ui.getMove(state)) {
                    state.setGameState(Constants.MAKE_MOVE);
                }
            }
        }
    }
}
