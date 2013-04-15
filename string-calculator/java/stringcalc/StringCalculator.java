package stringcalc;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = "[,\n]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//.\n.*";
    private static final int CUSTOM_DELIM_INDEX = 2;
    private static final int CUSTOM_DELIMITED_STRING_INDEX = 4;

    public int add(String s) throws Exception {
        if (s.isEmpty())
            return 0;

        return sumOfNumbersInString(s);
    }

    private int sumOfNumbersInString(String s) throws Exception {
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
        return s.substring(CUSTOM_DELIM_INDEX, CUSTOM_DELIM_INDEX + 1);
    }

    private int sumNumbersInDelimitedString(String s, String delimiter)
            throws Exception {
        int[] numbersInts = toIntArray(s, delimiter);
        
        int sum = 0;
        List<Integer> negatives = new ArrayList<Integer>();
        for (int n : numbersInts) {
            if (n < 0) {
                negatives.add(n);
            }
            sum += n;
        }
        
        if (!negatives.isEmpty()) {
            throw new Exception("negatives not allowed: " + negatives);
        }
        
        return sum;
    }

    private int[] toIntArray(String s, String delimiter) {
        String[] numbers = s.split(delimiter);
        int[] numbersInts = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersInts[i] = Integer.parseInt(numbers[i].trim());
        }
        return numbersInts;
    }
}
