import java.util.*;

class Student {
    String name;
    Map<String, Boolean> tasks;

    public Student(String name) {
        this.name = name;
        this.tasks = new HashMap<>();
        Arrays.asList("Task 1", "Task 2", "Task 3").forEach(task -> tasks.put(task, false));
    }
}

class Group {
    String groupName;
    List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }
}

public class ConsoleStudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Group> groups = new ArrayList<>();

        while (true) {
            System.out.println("1. Создать группу\n2. Добавить студента\n3. Удалить студента\n4. Удалить группу\n5. Просмотреть группы и студентов\n6. Выход");

            int choice = scanner.nextInt();
            String studentName, groupName;

            switch (choice) {
                case 1:
                    System.out.print("Название группы: ");
                    groups.add(new Group(scanner.next()));
                    System.out.println("Группа создана.");
                    break;

                case 2:
                    System.out.print("Имя студента: ");
                    studentName = scanner.next();
                    System.out.print("Название группы: ");
                    groupName = scanner.next();

                    groups.stream().filter(g -> g.groupName.equals(groupName)).findFirst().ifPresent(g -> {
                        g.students.add(new Student(studentName));
                        System.out.println("Студент добавлен в группу.");
                    });
                    break;

                case 3:
                    System.out.print("Имя студента для удаления: ");
                    studentName = scanner.next();

                    groups.forEach(g -> g.students.removeIf(s -> s.name.equals(studentName)));
                    System.out.println("Студент удален из группы.");
                    break;

                case 4:
                    System.out.print("Название группы для удаления: ");
                    groupName = scanner.next();

                    groups.removeIf(g -> g.groupName.equals(groupName));
                    System.out.println("Группа удалена.");
                    break;

                case 5:
                    System.out.println("Список групп и студентов:");
                    groups.forEach(g -> {
                        System.out.println("Группа: " + g.groupName);
                        g.students.forEach(s -> {
                            System.out.println("  - Студент: " + s.name + "\n    Задачи:");
                            s.tasks.forEach((task, completed) -> System.out.println("      " + task + ": " + (completed ? "Сдано" : "Не сдано")));
                        });
                    });
                    break;

                case 6:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
    }
}
