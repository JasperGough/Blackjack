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
                } else state.setGameState(Constants.DEALER_MOVES);
            } else if (gameState == Constants.MAKE_MOVE) {
                state.drawCard();
                state.setPlayerTotal(state.getCurrentCard());
                if (state.getPlayerTotal() > 21) {
                    ui.printBust(state, state.getPlayerName(), state.getPlayerTotal());
                    state.setPlayerTotal((state.getPlayerTotal()*-1)-1);
                    state.setGameState(Constants.WINNER);
                } else {
                    ui.printMove(state);
                    state.setGameState(Constants.GET_PLAYER_MOVE);
                }
            } else if (gameState == Constants.DEALER_MOVES) {
                for (int i = 0; i < 2; i++) {
                    state.drawCard();
                    state.setDealerTotal(state.getCurrentCard());
                }
                ui.printDealerStart(state);
                while (state.getDealerTotal() < 17) {
                    state.drawCard();
                    state.setDealerTotal(state.getCurrentCard());
                    ui.printDealerMove(state);
                    try
                    {
                        Thread.sleep(Constants.DELAY);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                if (state.getDealerTotal() > 21) {
                    ui.printBust(state, "Dealer", state.getDealerTotal());
                    state.setDealerTotal((state.getDealerTotal()*-1)-1);
                    state.setGameState(Constants.WINNER);
                }
            } else if (gameState == Constants.WINNER) {
                ui.printWinner(state);
                state.setGameState(Constants.GAME_OVER);
            } else if (gameState == Constants.GAME_OVER) {
                
            }
        }
    }
}
