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
		} else if (aPlayerHasHitFortyPoints()) {
			return getScoreForGameWithFourOrMorePoints();
		} else {
			return getScoreForGameWithLessThanFourPoints();
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

	private String getScoreForGameWithFourOrMorePoints() {
		if (pointsDifference() == 1)
			return "Advantage player1";
		else if (pointsDifference() == -1)
			return "Advantage player2";
		else if (pointsDifference() >= 2)
			return "Win for player1";
		else
			return "Win for player2";
	}

	private String getScoreForGameWithLessThanFourPoints() {
		String score = "";
		for (int i = 1; i < 3; i++) {
			int tempScore = LOVE;
			if (i == 1)
				tempScore = player1CurrentPoints;
			else {
				score += "-";
				tempScore = player2CurrentPoints;
			}
			switch (tempScore) {
			case LOVE:
				score += "Love";
				break;
			case FIFTEEN:
				score += "Fifteen";
				break;
			case THIRTY:
				score += "Thirty";
				break;
			case FORTY:
				score += "Forty";
				break;
			}
		}
		return score;
	}

	private boolean pointsAreTied() {
		return player1CurrentPoints == player2CurrentPoints;
	}

	private int pointsDifference() {
		return player1CurrentPoints - player2CurrentPoints;
	}

	private boolean aPlayerHasHitFortyPoints() {
		return player1CurrentPoints > FORTY || player2CurrentPoints > FORTY;
	}
}
