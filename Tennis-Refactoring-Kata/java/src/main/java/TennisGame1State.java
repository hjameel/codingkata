abstract class TennisGame1State {
    protected final int player1CurrentPoints;
    protected final int player2CurrentPoints;

    public TennisGame1State(int player1CurrentPoints, int player2CurrentPoints) {
        this.player1CurrentPoints = player1CurrentPoints;
        this.player2CurrentPoints = player2CurrentPoints;
    }

    public static TennisGame1State currentState(int player1CurrentPoints, int player2CurrentPoints) {
        if (player1CurrentPoints == player2CurrentPoints) {
            return new Tied(player1CurrentPoints, player2CurrentPoints);
        } else if (player1CurrentPoints > Constants.FORTY || player2CurrentPoints > Constants.FORTY) {
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
            case Constants.LOVE:
                return "Love-All";
            case Constants.FIFTEEN:
                return "Fifteen-All";
            case Constants.THIRTY:
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
            case Constants.LOVE:
                return "Love";
            case Constants.FIFTEEN:
                return "Fifteen";
            case Constants.THIRTY:
                return "Thirty";
            case Constants.FORTY:
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
