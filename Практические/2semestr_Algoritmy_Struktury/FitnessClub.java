import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FitnessClub {
    public static void main(String[] args) {
        List<String> visitors = new ArrayList<>();
        visitors.add("Пупа 100");
        visitors.add("Лупа 51");
        visitors.add("Миша 101");
        visitors.add("Катя 102");

        Collections.sort(visitors, Comparator.comparingInt(FitnessClub::getWeightSum));

        for (String visitor : visitors) {
            System.out.println(visitor);
        }
    }

    public static int getWeightSum(String visitor) {
        String weightString = visitor.split(" ")[1];
        int weight = Integer.parseInt(weightString);
        int sum = 0;
        while (weight > 0) {
            sum += weight % 10;
            weight /= 10;
        }
        return sum;
    }
}
