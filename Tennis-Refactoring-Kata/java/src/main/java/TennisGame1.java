public class TennisGame1 implements TennisGame {

	private int player1CurrentPoints = 0;
	private int player2CurrentPoints = 0;
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
		String score = "";
		if (pointsAreTied()) {
			score = getScoreForTiedGame();
		} else if (aPlayerHasScoredFourOrMore()) {
			score = getScoreForGameWithFourOrMorePoints();
		} else {
			score = getScoreForGameWithLessThanFourPoints(score);
		}
		return score;
	}

	private String getScoreForGameWithLessThanFourPoints(String score) {
		for (int i = 1; i < 3; i++) {
		    int tempScore = 0;
			if (i == 1)
				tempScore = player1CurrentPoints;
			else {
				score += "-";
				tempScore = player2CurrentPoints;
			}
			switch (tempScore) {
			case 0:
				score += "Love";
				break;
			case 1:
				score += "Fifteen";
				break;
			case 2:
				score += "Thirty";
				break;
			case 3:
				score += "Forty";
				break;
			}
		}
		return score;
	}

	private String getScoreForGameWithFourOrMorePoints() {
		String score;
		int minusResult = player1CurrentPoints - player2CurrentPoints;
		if (minusResult == 1)
			score = "Advantage player1";
		else if (minusResult == -1)
			score = "Advantage player2";
		else if (minusResult >= 2)
			score = "Win for player1";
		else
			score = "Win for player2";
		return score;
	}

	private String getScoreForTiedGame() {
		String score;
		switch (player1CurrentPoints) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;

		}
		return score;
	}

	private boolean pointsAreTied() {
		return player1CurrentPoints == player2CurrentPoints;
	}

	private boolean aPlayerHasScoredFourOrMore() {
		return player1CurrentPoints >= 4 || player2CurrentPoints >= 4;
	}
}
