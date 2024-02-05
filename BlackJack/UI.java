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
}
