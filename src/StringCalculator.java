public class StringCalculator {
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            if (numbers.startsWith("//[")) {
                numberString = extractMultipleDelimiters(numbers);
            } else {
                delimiter = numbers.substring(2, 3);
                numberString = numbers.substring(4);
            }
        }

        String[] nums = numberString.split("[" + delimiter + "\\n]");
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String num : nums) {
            if (!num.trim().isEmpty()) {
                int n = Integer.parseInt(num.trim());
                if (n < 0) {
                    if (negatives.length() > 0) {
                        negatives.append(", ");
                    }
                    negatives.append(n);
                } else if (n <= 1000) {
                    sum += n;
                }
            }
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: [" + negatives + "]");
        }

        return sum;
    }

    private String extractMultipleDelimiters(String numbers) {
        int closeBracketIndex = numbers.indexOf("]\n");
        String delimiters = numbers.substring(2, closeBracketIndex + 1);
        return numbers.substring(closeBracketIndex + 2);
    }
}
