import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Описание задачи:
        Напишите программу, которая занимается учетом сотрудников и помогает кадрам и бухгалтерии автоматизировать процессы.
        С помощью вашей программы бухгалтерия и отдел кадров смогут узнавать следующую информацию:
        1. Получить список всех сотрудников.
        2. Посчитать сумму затрат на зарплаты.
        3. Найти сотрудника с минимальной заплатой.
        4. Найти сотрудника с максимальной зарплатой.
        5. Подсчитать среднее значение зарплат.
        */
        Employee[] employees = new Employee[16];
        employees[0] = new Employee("Joseph Aulsford", 5, 13_000);
        employees[1] = new Employee("Richard Selby", 6, 12_000);
        employees[2] = new Employee("Cheston Furrow", 1, 11_000);
        employees[3] = new Employee("Michael Kane", 3, 9_000);
        employees[4] = new Employee("Harry Maguire", 6, 10_000);
        employees[5] = new Employee("Emma Furrow", 2, 13_000);
        employees[6] = new Employee("Bill Murray", 5, 15_000);
        employees[7] = new Employee("John Lennon", 6, 19_000);
        employees[8] = new Employee("Harvey Oswald", 4, 16_000);
        employees[9] = new Employee("Julia Mill", 4, 20_000);
        employees[10] = new Employee("Ann Potter", 3, 10_000);
        employees[11] = new Employee("Emma Watson", 3, 13_000);
        employees[12] = new Employee("Joshua Hawk", 2, 17_000);
        employees[13] = new Employee("Yoko Lennon", 2, 14_000);
        employees[14] = new Employee("James Dent", 1, 18_000);
        employees[15] = new Employee("Lily Blunt", 1, 21_000);

        Scanner in = new Scanner(System.in);
        System.out.println("1. Получить список всех сотрудников." + "\n" +
                "2. Посчитать сумму затрат на зарплаты." + "\n" +
                "3. Найти сотрудника с минимальной заплатой." + "\n" +
                "4. Найти сотрудника с максимальной зарплатой." + "\n" +
                "5. Подсчитать среднее значение зарплат." + "\n" +
                "6. Вывод по id." + "\n" +
                "7. Индексация зарплат." + "\n" +
                "8. Данные по департаменту." + "\n" +
                "9. Отсечка по зарплате." + "\n" +
                "10. Выход.");
        int command = in.nextInt();
        EmployeeBook employeeBook = new EmployeeBook(employees);
        employeeBook.menu(command);
    }
}