public class AsciiDecoder {

    public static String decode(String s) {
        // Step 1: reverse the string
        String reversed = new StringBuilder(s).reverse().toString();

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < reversed.length()) {

            // Step 2: try 3-digit ASCII first
            if (i + 3 <= reversed.length()) {
                int three = Integer.parseInt(reversed.substring(i, i + 3));

                if ((three >= 65 && three <= 90) ||
                    (three >= 97 && three <= 122)) {

                    result.append((char) three);
                    i += 3;
                    continue;
                }
            }

            // Step 3: fallback to 2-digit ASCII
            int two = Integer.parseInt(reversed.substring(i, i + 2));

            if (two == 32) {
                result.append(' ');
                i += 2;
            } else {
                // According to problem statement, this should not happen
                throw new IllegalArgumentException("Invalid encoding");
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String encoded = "729799107101114328297110107";
        System.out.println(decode(encoded)); // Hacker Rank
    }
}
