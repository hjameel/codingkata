package stringcalc;

public class StringCalculator {

	public int add(String s) {
		if (s.isEmpty())
			return 0;

		return sumOfNumbersInString(s);
	}

	private int sumOfNumbersInString(String s) {
		int sum = 0;
		String[] numbers = s.split(",");
		for (String number : numbers) {
			sum += Integer.parseInt(number.trim());
		}
		return sum;
	}
}
