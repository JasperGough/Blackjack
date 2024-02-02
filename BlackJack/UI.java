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
   public String getMove() {
       System.out.printf(Constants.GET_MOVE, );
       
   }
}
