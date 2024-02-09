
public class State
{
    private int[][] deck = {
        {1,1,1,1},
        {2,2,2,2},
        {3,3,3,3},
        {4,4,4,4},
        {5,5,5,5},
        {6,6,6,6},
        {7,7,7,7},
        {8,8,8,8},
        {9,9,9,9},
        {10,10,10,10},
        {11,11,11,11},
        {12,12,12,12},
        {13,13,13,13}
    };
    private String playerName = "";
    private int gameState = Constants.STANDBY;
    private int playerTotal = 0;
    private int dealerTotal = 0;
    private int currentCard = 0;
    private int card;
    private int suit;
    private String currentCardString = "";
    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
    public int getGameState() {
        return this.gameState;
    }
    public void shuffleDeck() {
        for (int i = 0; i < Constants.SUIT_SIZE; i++) {
            for (int j = 0; j < Constants.SUIT_NUMBER; j++) {
                deck[i][j] = i+1;
            }
        }
    }
    public void getDeck() {
        for (int i = 0; i < Constants.SUIT_SIZE; i++) {
            for (int j = 0; j < Constants.SUIT_NUMBER; j++) {
                System.out.print(deck[i][j]);
            }
            System.out.println();
        }
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerTotal(int value) {
        this.playerTotal+=value;
        if (playerTotal > 21) {
            playerTotal = -1;
        }
    }
    public int getPlayerTotal() {
        return playerTotal;
    }
    public void setDealerTotal(int value) {
        this.dealerTotal+=value;
        if (dealerTotal > 21) {
            dealerTotal = -1;
        }
    }
    public int getDealerTotal() {
        return dealerTotal;
    }
    public String getResult() {
        if (playerTotal > dealerTotal) {
            return playerName;
        } else if (dealerTotal > playerTotal) {
            return "Dealer";
        } else
        return "Nobody";
    }
    public void drawCard() {
        currentCard=0;
        while (currentCard == 0) {
            card =(int)(Math.random()*12);
            suit = (int)Math.random()*3;
            currentCard = deck[card][suit];
        }
        if (currentCard == 11) {
            currentCardString = "jack";
            currentCard = 10;
        } else if (currentCard == 12) {
            currentCardString = "queen";
            currentCard = 10;
        } else if (currentCard == 13) {
            currentCardString = "king";
            currentCard = 10;
        } else {
            currentCardString = Integer.toString(currentCard);
        }
        deck[card][suit] = 0;
    }
    public int getCurrentCard() {
        return currentCard;
    }
    public String getCurrentCardString() {
        return currentCardString;
    }
}
