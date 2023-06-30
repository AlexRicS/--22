public class RomanToArabicConverter {
    private static final String[] ROMAN_NUMERALS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static final int[] ARABIC_NUMERALS = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public static int convertToArabic(String romanNumber) {
        int arabic = 0;
        int i = 0;

        while (i < romanNumber.length()) {
            for (int j = 0; j < ROMAN_NUMERALS.length; j++) {
                if (romanNumber.startsWith(ROMAN_NUMERALS[j], i)) {
                    arabic += ARABIC_NUMERALS[j];
                    i += ROMAN_NUMERALS[j].length();
                    break;
                }
            }
        }

        return arabic;
    }

    public static void main(String[] args) {
        String romanNumber = "VI"; // Указываем любое число
        int arabicNumber = convertToArabic(romanNumber);
        System.out.println(romanNumber + " в арабских числах: " + arabicNumber);
    }
}
