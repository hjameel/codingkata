package stringcalc;

public class StringCalculator {

	public int add(String s) {
		if (s.isEmpty())
			return 0;

		return sumOfNumbersInString(s);
	}

	private int sumOfNumbersInString(String s) {
		String delimiter = "[,\n]";
		if (s.matches("//.\n.*")) {
			delimiter = s.substring(2, 3);
			s = s.substring(4);
		}
		
		int sum = 0;
		String[] numbers = s.split(delimiter);
		for (String number : numbers) {
			sum += Integer.parseInt(number.trim());
		}
		return sum;
	}
}
