public class TennisGame1 implements TennisGame {
    private int player1CurrentPoints = Score.LOVE;
    private int player2CurrentPoints = Score.LOVE;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1CurrentPoints++;
        else if (playerName.equals(player2Name))
            player2CurrentPoints++;
    }

    public String getScore() {
        return TennisGame1State.currentState(player1CurrentPoints, player2CurrentPoints).getScore();
    }
}

