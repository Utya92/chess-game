import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;


public class ChessMain {

    //

    public static void main(String[] args) {
        Info info = new Info();
        try {
            info.getInfoAllPlayers();
        } catch (InputMismatchException i) {
            System.out.println("введенное значение не может быть строкой");
        }


    }


    public ArrayList<Player> createPlayers() {
        Player whitePlayer = new Player("Beth Harmon", "bethharmon@gmail.com", true, 2000, 20);
        Player blackPlayer = new Player("Lexa Petrov", "xabza@gmail.com", false, 2500, 39);
        ArrayList<Player> players = new ArrayList<>();
        players.add(whitePlayer);
        players.add(blackPlayer);
        return players;

    }

    public HashMap<String, Piece> createPieces() {

        King whiteKing = new King(new Spot("h", 7), "white_king", true);
        King blackKing = new King(new Spot("d", 8), "black_king", true);
        Knight blackKnight = new Knight(new Spot("d", 6), "black_knight", false);
        Rook whiteRook1 = new Rook(new Spot("g", 7), "white_rook1", true);
        Rook whiteRook2 = new Rook(new Spot("g", 7), "white_rook2", true);
        HashMap<String, Piece> hashMap = new HashMap<>();
        hashMap.put(whiteKing.getId(), whiteKing);
        hashMap.put(blackKing.getId(), blackKing);
        hashMap.put(blackKnight.getId(), blackKnight);
        hashMap.put(whiteRook1.getId(), whiteRook1);
        hashMap.put(whiteRook2.getId(), whiteRook2);
        return hashMap;
    }

    public void play(ArrayList<Player> players, HashMap<String, Piece> hashMap) {
        try {
            players.get(0).movePiece(hashMap.get("black_king"), new Spot("a", 8));

        } catch (IllegalArgumentException e) {
            System.out.println("неправильный ход!");
        }
        players.get(1).movePiece(hashMap.get("black_knight"), new Spot("c", 8));

    }

}
