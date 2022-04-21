import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Info {
    ChessMain chessMain = new ChessMain();
    ArrayList<Player> players = chessMain.createPlayers();
    Scanner scanner = new Scanner(System.in);

    public void getInfoAllPlayers() throws InputMismatchException {
        System.out.println("enter random number from 1 to 10");

        if (scanner.nextInt() > 10) {
            System.out.println("range must not exceed 1 to 10");
            scanner.close();
            return;
        }
        for (Player player : players) {
            System.out.println(player);
            scanner.close();
        }
    }

}
