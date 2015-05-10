public class TennisGame1 implements TennisGame {
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    public static final int FORTY = 3;
    private int player1CurrentPoints = LOVE;
    private int player2CurrentPoints = LOVE;
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
        switch (getState()) {
            case tied:
                return getScoreForTiedGame();
            case beyondDeuceBoundary:
                return getScoreForGamePassedTheDeuceBoundary();
            default:
                return getScoreForGameUnderDeuceBoundary();
        }
    }

    private GameState getState() {
        return TennisGame1State.newState(player1CurrentPoints, player2CurrentPoints).getGameState();
    }

    private String getScoreForTiedGame() {
        switch (player1CurrentPoints) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreForGamePassedTheDeuceBoundary() {
        if (pointsDifference() == 1)
            return "Advantage player1";
        else if (pointsDifference() == -1)
            return "Advantage player2";
        else if (pointsDifference() >= 2)
            return "Win for player1";
        else
            return "Win for player2";
    }

    private String getScoreForGameUnderDeuceBoundary() {
        return getScoreFromPoints(player1CurrentPoints) + "-"
                + getScoreFromPoints(player2CurrentPoints);
    }

    private String getScoreFromPoints(int points) {
        switch (points) {
            case LOVE:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            case FORTY:
                return "Forty";
            default:
                return "";
        }
    }

    private int pointsDifference() {
        return player1CurrentPoints - player2CurrentPoints;
    }
}

enum GameState {
    tied,
    underDeuceBoundary,
    beyondDeuceBoundary
}

abstract class TennisGame1State {
    abstract GameState getGameState();

    public static TennisGame1State newState(int player1CurrentPoints, int player2CurrentPoints) {
        if (player1CurrentPoints == player2CurrentPoints) {
            return new Tied();
        } else if (player1CurrentPoints > TennisGame1.FORTY || player2CurrentPoints > TennisGame1.FORTY) {
            return new BeyondDeuceBoundary();
        } else {
            return new UnderDeuceBoundary();
        }
    }
}

class Tied extends TennisGame1State {

    @Override
    GameState getGameState() {
        return GameState.tied;
    }

}

class UnderDeuceBoundary extends TennisGame1State {

    @Override
    GameState getGameState() {
        return GameState.underDeuceBoundary;
    }

}

class BeyondDeuceBoundary extends TennisGame1State {

    @Override
    GameState getGameState() {
        return GameState.beyondDeuceBoundary;
    }

}