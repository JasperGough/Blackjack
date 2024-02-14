import java.util.Scanner;


public class UI
{
   Scanner scanner;
   public UI() {
       scanner = new Scanner(System.in);
   }
   public String promptForName() {
       System.out.print(Constants.GET_PLAYER_NAME);
       return scanner.next();
   }
   public boolean getMove(State state) {
       System.out.printf(Constants.GET_MOVE, state.getPlayerName(), state.getPlayerTotal());
       String hit = scanner.next();
       return hit.equalsIgnoreCase("Y");
   }
   public void printInvalidChoice() {
       System.out.println(Constants.INVALID_CHOICE);
   }
   public void printDeckShuffled() {
       System.out.println(Constants.SHUFFLED);
   }
   public void printGameStart() {
       System.out.println(Constants.GAME_BEGIN);
   }
   public void printWinner (State state) {
       System.out.printf(Constants.GAME_WIN, state.getResult());
       System.out.println();
   }
   public void printMove (State state) {
       System.out.printf(Constants.PRINT_DRAW, state.getCurrentCardString(), state.getPlayerTotal());
       System.out.println();
   }
   public void printDealerMove (State state) {
       System.out.printf(Constants.DEALER_HIT, state.getCurrentCardString(), state.getDealerTotal());
       System.out.println();
   }
   public boolean getShuffle() {
       System.out.println(Constants.SHUFFLE);
       String answer = scanner.next();
       return answer.equalsIgnoreCase("Y");
   }
   public void printBust(State state, String player, int total) {
       System.out.printf(Constants.BUST, player, total);
       System.out.println();
   }
   public void printDealerStart(State state) {
       System.out.printf(Constants.DEALER_START, state.getDealerTotal());
       System.out.println("");
   }
   public boolean playAgain() {
       System.out.println(Constants.ROUND_TWO);
       String answer = scanner.next();
       return answer.equalsIgnoreCase("Y");
   }
}
