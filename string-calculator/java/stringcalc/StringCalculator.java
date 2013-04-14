package stringcalc;

public class StringCalculator {
	
	private static final String DEFAULT_DELIMITER = "[,\n]";
	private static final String CUSTOM_DELIMITER_PATTERN = "//.\n.*";
	private static final int CUSTOM_DELIM_INDEX = 2;
	private static final int CUSTOM_DELIMITED_STRING_INDEX = 4;

	public int add(String s) {
		if (s.isEmpty())
			return 0;

		return sumOfNumbersInString(s);
	}

	private int sumOfNumbersInString(String s) {
		String delimiter = DEFAULT_DELIMITER;
		if (hasCustomDelimiter(s)) {
			delimiter = getCustomDelimiter(s);
			s = removeDelimiterSpecifierFromString(s);
		}
		
		return sumNumbersInDelimitedString(s, delimiter);
	}

	private boolean hasCustomDelimiter(String s) {
		return s.matches(CUSTOM_DELIMITER_PATTERN);
	}

	private String removeDelimiterSpecifierFromString(String s) {
		s = s.substring(CUSTOM_DELIMITED_STRING_INDEX);
		return s;
	}

	private String getCustomDelimiter(String s) {
		return s.substring(CUSTOM_DELIM_INDEX,
				CUSTOM_DELIM_INDEX + 1);
	}
	
	private int sumNumbersInDelimitedString(String s, String delimiter) {
		int sum = 0;
		String[] numbers = s.split(delimiter);
		for (String number : numbers) {
			sum += Integer.parseInt(number.trim());
		}
		return sum;
	}
}
