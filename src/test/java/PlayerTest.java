import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class PlayerTest {
    private static ArrayList<Player> players;
    private static HashMap<String, Piece> hashMap;

    @BeforeAll
    public static void setUp() {
        ChessMain chessMain = new ChessMain();
        players = chessMain.createPlayers();
        hashMap = chessMain.createPieces();
    }

    @BeforeEach
    private void beforeEach() {
        System.out.println("running beforeEach");
    }

    @AfterEach
    private void afterEach() {
        System.out.println("running afterEach");

    }

    @AfterAll
    private static void afterAll() {
        System.out.println("running afterAll ");
    }

    @Test
    public void validMoveTest() {
        players.get(0).movePiece(hashMap.get("white_king"), new Spot("b", 4));
        Assertions.assertEquals(4, hashMap.get("white_king").getSpot().getY());

    }

    @Test
    public void invalidMovePieceColorTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePiece(hashMap.get("black_knight"), new Spot("b", 4));
        });

    }

    @Test
    public void invalidMoveBadSpotTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            players.get(0).movePiece(hashMap.get("white_king"), new Spot("x", 4));
        });

    }

    @Test
    public void playerCreateSuccess() {
        Player blackPlayer = new Player("Alex Petrov", "alex@gmail.com", false, 2500, 39);
        Assertions.assertEquals("Alex Petrov", blackPlayer.getName());
        Assertions.assertEquals("alex@gmail.com", blackPlayer.getEmail());
        Assertions.assertFalse(blackPlayer.isWhite());
        Assertions.assertEquals(2500, blackPlayer.getRank());
        Assertions.assertEquals(39, blackPlayer.getAge());
    }

    @ParameterizedTest
    @MethodSource("nameError")
    public void playerCreateIncorrectNameTest(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player(name, "alex@gmailcom", false, 2500, 39);
        });

    }

    static Stream<String> nameError() {
        return Stream.of(null, "  ", "");

    }

    @ParameterizedTest
    @MethodSource("emailError")
    public void playerCreateIncorrectEmailTest(String email) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Player player = new Player("Alex Petrov", email, false, 2500, 39);
        });

    }

    static Stream<String> emailError() {
        return Stream.of(null, "  ", "alex@gmail.com");

    }

}

