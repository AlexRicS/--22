public class NumberCount {
    public static int countNumbers(int[][] intervals) {
        int count = 0;
        for (int[] interval : intervals) {
            count += interval[1] - interval[0] - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {6, 100}, {11, 15}};
        int result = countNumbers(intervals);
        System.out.println("Кол-во числе в интервале равно: " + result);
    }
}
