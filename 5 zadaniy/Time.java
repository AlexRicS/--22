import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество секунд: ");
        long seconds = scanner.nextLong();

        long years = seconds / (365 * 24 * 60 * 60);
        long days = (seconds % (365 * 24 * 60 * 60)) / (24 * 60 * 60);
        long hours = (seconds % (24 * 60 * 60)) / (60 * 60);
        long minutes = (seconds % (60 * 60)) / 60;
        long remainingSeconds = seconds % 60;

        if (years > 0) {
            System.out.print(years + " год, ");
        }
        if (days > 0) {
            System.out.print(days + " день, ");
        }
        if (hours > 0) {
            System.out.print(hours + " час, ");
        }
        if (minutes > 0) {
            System.out.print(minutes + " минута и ");
        }
        if (remainingSeconds > 0) {
            System.out.print(remainingSeconds + " секунд");
        }

        System.out.println();

        scanner.close();
    }
}
