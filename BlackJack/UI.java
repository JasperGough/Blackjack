import java.util.Scanner;


public class UI
{
   Scanner scanner;
   public UI() {
       scanner = new Scanner(System.in);
   }
   public String promptForName() {
       System.out.println(Constants.GET_PLAYER_NAME);
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
   public void printWinner (State state) {
       System.out.printf(Constants.GAME_WIN, state.getResult());
       System.out.println();
   }
   public void printMove (State state) {
       
   }
}
