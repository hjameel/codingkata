package stringcalc;

public class StringCalculator {

	public int add(String s) {
		if (s.isEmpty())
			return 0;
		if (s.contains(",")) {
			String[] numbers = s.split(",");
			int sum = 0;
			for (String number : numbers) {
				sum += Integer.parseInt(number.trim());
			}
			return sum;
		}
		return Integer.parseInt(s);
	}
}
