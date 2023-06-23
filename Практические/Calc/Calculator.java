import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static final String FILE_PATH = "history.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> history = loadHistory(); // Загрузка истории

        while (true) {
            System.out.print("Введите выражение (выход -/q, история - /history): ");
            String input = scanner.nextLine();

            if (input.equals("/q")) {
                System.out.println("Программа завершена.");
                break;
            } else if (input.equals("/history")) {
                printHistory(history); // Вывод истории
                continue;
            }

            try {
                double result = evaluateExpression(input);
                System.out.println("Результат: " + result);

                // Сохранение выражения и результата в историю
                String historyEntry = input + " = " + result;
                history.add(historyEntry);
                saveHistory(history); // Сохранение истории в файл
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static double evaluateExpression(String expression) {
        expression = expression.replace(" ", ""); // Удаляем пробелы из выражения

        // Проверяем выражение на наличие недопустимых символов
        if (!expression.matches("[\\d()+\\-*/%^|]+")) {
            throw new IllegalArgumentException("Недопустимые символы в выражении");
        }

        try {
            return evaluate(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Некорректное выражение");
        }
    }

    private static double evaluate(String expression) {
        return evalExpression(expression.toCharArray(), new int[]{0});
    }

    private static double evalExpression(char[] expression, int[] index) {
        double result = evalTerm(expression, index);

        while (index[0] < expression.length) {
            char operator = expression[index[0]];

            if (operator == '+' || operator == '-') {
                index[0]++;
                double term = evalTerm(expression, index);

                if (operator == '+') {
                    result += term;
                } else {
                    result -= term;
                }
            } else {
                break;
            }
        }

        return result;
    }

    private static double evalTerm(char[] expression, int[] index) {
        double result = evalFactor(expression, index);

        while (index[0] < expression.length) {
            char operator = expression[index[0]];

            if (operator == '*' || operator == '/' || operator == '%' || operator == '^') {
                index[0]++;
                double factor = evalFactor(expression, index);

                switch (operator) {
                    case '*':
                        result *= factor;
                        break;
                    case '/':
                        result /= factor;
                        break;
                    case '%':
                        result %= factor;
                        break;
                    case '^':
                        result = Math.pow(result, factor);
                        break;
                }
            } else {
                break;
            }
        }

        return result;
    }

    private static double evalFactor(char[] expression, int[] index) {
        char currentChar = expression[index[0]];

        if (currentChar == '+') {
            index[0]++;
            return evalFactor(expression, index);
        } else if (currentChar == '-') {
            index[0]++;
            return -evalFactor(expression, index);
        } else if (currentChar == '(') {
            index[0]++;
            double result = evalExpression(expression, index);

            if (expression[index[0]] != ')') {
                throw new IllegalArgumentException("Некорректное выражение");
            }

            index[0]++;
            return result;
        } else if (Character.isDigit(currentChar)) {
            StringBuilder num = new StringBuilder();

            while (index[0] < expression.length && (Character.isDigit(expression[index[0]]) || expression[index[0]] == '.')) {
                num.append(expression[index[0]]);
                index[0]++;
            }

            return Double.parseDouble(num.toString());
        } else if (currentChar == '|') {
            index[0]++;
            double result = evalExpression(expression, index);

            if (result < 0) {
                result = -result;
            }

            if (expression[index[0]] != '|') {
                throw new IllegalArgumentException("Некорректное выражение");
            }

            index[0]++;
            return result;
        } else {
            throw new IllegalArgumentException("Некорректное выражение");
        }
    }

    private static List<String> loadHistory() {
        List<String> history = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            // Обработка ошибок чтения
            System.out.println("Ошибка при чтении файла истории: " + e.getMessage());
        }

        return history;
    }

    private static void saveHistory(List<String> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            // Обработка ошибок записи файла
            System.out.println("Ошибка при записи файла истории: " + e.getMessage());
        }
    }

    private static void printHistory(List<String> history) {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
        } else {
            System.out.println("История вычислений:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }
}
