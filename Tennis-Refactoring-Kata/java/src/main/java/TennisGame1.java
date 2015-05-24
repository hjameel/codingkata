public class TennisGame1 implements TennisGame {
    private static final int LOVE = 0;
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
        return TennisGame1State.currentState(player1CurrentPoints, player2CurrentPoints).getScore();
    }
}

abstract class TennisGame1State {
    protected static final int LOVE = 0;
    protected static final int FIFTEEN = 1;
    protected static final int THIRTY = 2;
    protected static final int FORTY = 3;
    protected final int player1CurrentPoints;
    protected final int player2CurrentPoints;

    public TennisGame1State(int player1CurrentPoints, int player2CurrentPoints) {
        this.player1CurrentPoints = player1CurrentPoints;
        this.player2CurrentPoints = player2CurrentPoints;
    }

    public static TennisGame1State currentState(int player1CurrentPoints, int player2CurrentPoints) {
        if (player1CurrentPoints == player2CurrentPoints) {
            return new Tied(player1CurrentPoints, player2CurrentPoints);
        } else if (player1CurrentPoints > FORTY || player2CurrentPoints > FORTY) {
            return new BeyondDeuceBoundary(player1CurrentPoints, player2CurrentPoints);
        } else {
            return new UnderDeuceBoundary(player1CurrentPoints, player2CurrentPoints);
        }
    }

    abstract String getScore();
}

class Tied extends TennisGame1State {

    public Tied(int player1CurrentPoints, int player2CurrentPoints) {
        super(player1CurrentPoints, player2CurrentPoints);
    }

    @Override
    protected String getScore() {
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
}

class UnderDeuceBoundary extends TennisGame1State {
    public UnderDeuceBoundary(int player1CurrentPoints, int player2CurrentPoints) {
        super(player1CurrentPoints, player2CurrentPoints);
    }

    @Override
    protected String getScore() {
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
}

class BeyondDeuceBoundary extends TennisGame1State {

    public BeyondDeuceBoundary(int player1CurrentPoints, int player2CurrentPoints) {
        super(player1CurrentPoints, player2CurrentPoints);
    }

    @Override
    protected String getScore() {
        if (pointsDifference() == 1)
            return "Advantage player1";
        else if (pointsDifference() == -1)
            return "Advantage player2";
        else if (pointsDifference() >= 2)
            return "Win for player1";
        else
            return "Win for player2";
    }

    private int pointsDifference() {
        return player1CurrentPoints - player2CurrentPoints;
    }
}