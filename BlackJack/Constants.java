
public class Constants
{
    public static final int DECK_SIZE = 52;
    public static final int SUIT_SIZE = 13;
    public static final int SUIT_NUMBER = 4;
    public static final int DELAY=1000;
    
    public static final int STANDBY = 0;
    public static final int GET_NAME = 1;
    public static final int GET_SHUFFLE = 2;
    public static final int START_GAME = 3;
    public static final int GET_PLAYER_MOVE = 4;
    public static final int MAKE_MOVE = 5;
    public static final int DEALER_MOVES = 6;
    public static final int WINNER = 7;
    public static final int GAME_OVER = 8;
    public static final int QUIT_PROGRAM = 9;
    
    public static final String GET_PLAYER_NAME = "What is your name? -->";
    public static final String SHUFFLE = "Would you like to shuffle? (Y/N)";
    public static final String SHUFFLED = "Deck shuffled";
    public static final String GAME_BEGIN = "Game start! You begin by drawing two cards.";
    public static final String GET_MOVE = "%s, your total is %d, Would you like to hit? (Y/N)";
    public static final String PRINT_DRAW = "You drew a %s, your total is now %d.";
    public static final String INVALID_CHOICE = "Please pick either Y or N.";
    public static final String DEALER_START = "You stand. Dealer starts with a total of %d.";
    public static final String DEALER_HIT = "Dealer drew a %s, their total is now %d.";
    public static final String BUST = "%s busted with a total of %d.";
    public static final String DEALER_STAND = "Dealer stands. They have %d to your %d.";
    public static final String GAME_WIN = "%s wins!";
    public static final String ROUND_TWO = "Play again? (Y/N)";
}
