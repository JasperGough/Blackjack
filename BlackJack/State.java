
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
    private int card;
    private int suit;
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
        currentCard=0;
        if (currentCard == 0) {
            card =(int)(Math.random()*12);
            suit = (int)Math.random()*3;
            currentCard = deck[card][suit];
        }
        deck[card][suit] = 0;
    }
    public int getCurrentCard() {
        return currentCard;
    }
}
