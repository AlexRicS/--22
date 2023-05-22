import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicateWords {
    public static void main(String[] args) {
        String input = "abc abc ab abc ab acs acs";

        // Делим строки на слова тут
        String[] words = input.split(" ");

        // с помощью LinkedHashSet проверяем на повтор слов
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));

        // строим строку без повторных слов
        StringBuilder result = new StringBuilder();
        for (String word : uniqueWords) {
            result.append(word).append(" ");
        }

        // Итог
        System.out.println(result.toString().trim());
    }
}
