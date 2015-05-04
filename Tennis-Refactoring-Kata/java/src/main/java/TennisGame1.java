public class TennisGame1 implements TennisGame {

	private static final int LOVE = 0;
	private static final int FIFTEEN = 1;
	private static final int THIRTY = 2;
	private static final int FORTY = 3;
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
		if (pointsAreTied()) {
			return getScoreForTiedGame();
		} else if (theDeuceBoundaryHasBeedPassed()) {
			return getScoreForGamePassedTheDeuceBoundary();
		} else {
			return getScoreForGameUnderDeuceBoundary();
		}
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

	private boolean pointsAreTied() {
		return player1CurrentPoints == player2CurrentPoints;
	}

	private int pointsDifference() {
		return player1CurrentPoints - player2CurrentPoints;
	}

	private boolean theDeuceBoundaryHasBeedPassed() {
		return player1CurrentPoints > FORTY || player2CurrentPoints > FORTY;
	}
}
