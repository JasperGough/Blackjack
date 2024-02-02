
public class State
{
    int[][] deck = {
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
        {Constants.JACK,Constants.JACK,Constants.JACK,Constants.JACK},
        {Constants.QUEEN,Constants.QUEEN,Constants.QUEEN,Constants.QUEEN},
        {Constants.KING,Constants.KING,Constants.KING,Constants.KING}
    };
    private String playerName = "";
    private int gameState = Constants.STANDBY;
    private int playerTotal = 0;
    private int dealerTotal = 0;
    private int currentCard = 0;
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerTotal(int card) {
        this.playerTotal+=card;
    }
    public int getPlayerTotal() {
        return playerTotal;
    }
    public void setDealerTotal() {
        this.dealerTotal+=currentCard;
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
        int suit = (int)Math.random()*3;
        int card = (int)(Math.random()*12);
        currentCard = deck[card][suit];
        deck[suit][card] = 0;
    }
    public int getCurrentCard() {
        return currentCard;
    }
}
