import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Info {
    ChessMain chessMain = new ChessMain();
    ArrayList<Player> players = chessMain.createPlayers();
    Scanner scanner = new Scanner(System.in);

    public void getInfoAllPlayers() throws InputMismatchException {
        System.out.println("введите любое число от 1 до 10");

        if (scanner.nextInt() > 10) {
            System.out.println("диапазон не должен превышать от 1 до 10");
            scanner.close();
            return;
        }
        for (Player player : players) {
            System.out.println(player);
            scanner.close();
        }
    }

}
