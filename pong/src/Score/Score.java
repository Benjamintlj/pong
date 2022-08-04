package Score;

public class Score {

    private static int player1Score = 0;
    private static int player2Score = 0;

    public static void increasePlayer1Score() {
        player1Score++;
    }

    public static String getPlayer1Score() {
        return "Player1: " + player1Score;
    }

    public static void increasePlayer2Score() {
        player2Score++;
    }

    public static String getPlayer2Score() {
        return "Player2: " + player2Score;
    }
}
