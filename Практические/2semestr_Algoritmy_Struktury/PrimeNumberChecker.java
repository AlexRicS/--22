public class PrimeNumberChecker {
    public static void main(String[] args) {
        int number = 19; // Тут указываем число которе проверяем

        if (isPrime(number)) {
            System.out.println(number + " - простое число");
        } else {
            System.out.println(number + " - не является простым числом");
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
