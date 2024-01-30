public class RomanConverter {
    private static final String[] ROMAN_NUMERALS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static final int[] ARABIC_NUMERALS = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public static String convertToRoman(int number) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (number >= ARABIC_NUMERALS[i]) {
                roman.append(ROMAN_NUMERALS[i]);
                number -= ARABIC_NUMERALS[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        int years = 112; // Указываем любое число 
        String romanYears = convertToRoman(years);
        System.out.println(years + " год(а/лет) в римских числах: " + romanYears);
    }
}
