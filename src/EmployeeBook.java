import java.util.Scanner;

public class EmployeeBook {
    Employee[] employees;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }

    public void menu(int command) {
        Scanner in = new Scanner(System.in);
        switch (command) {
            case 1:
                list(1,0);
                System.out.println();
                break;
            case 2:
                System.out.println("Cумма затрат на зарплаты: " + salaryCosts(1, 0));
                System.out.println();
                break;
            case 3:
                searchMin(1, 0);
                System.out.println();
                break;
            case 4:
                searchMax(1, 0);
                System.out.println();
                break;
            case 5:
                averageSalary(1, 0);
                System.out.println();
                break;
            case 6:
                System.out.println("Введите ID сотрудника: ");
                int idNum = in.nextInt();
                searchId(idNum);
                System.out.println();
                break;

            case 7:
                System.out.println("Введите % индексации: ");
                int num = in.nextInt();
                salaryIndexing(1,num, 0);
                list(1, 0);
                System.out.println();
                break;
            case 8:
                System.out.println("Введите номер департамента: ");
                int departmentX = in.nextInt();
                searchMin(2, departmentX);
                searchMax(2, departmentX);
                System.out.println("Cумма затрат на зарплаты: " + salaryCosts(2,departmentX));
                averageSalary(2, departmentX);
                System.out.println();
                System.out.println("Введите % индексации для департамента: ");
                int numD = in.nextInt();
                salaryIndexing(2, numD, departmentX);
                System.out.println();
                list(2, departmentX);
                System.out.println();
                break;

            case 9:
                System.out.println("Введите отсечку по зарплате: ");
                int salaryCutoff = in.nextInt();
                salaryCutoff(salaryCutoff);
                break;
            case 10:
                break;

            default:
                throw new RuntimeException("Ошибка ввода");
        }
    }
    public void list(int way, int department) {
        switch (way) {
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    System.out.println(String.format("ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[i].getNumber(),
                            employees[i].getFullName(), employees[i].getDepartment(), employees[i].getWage()));
                }
                break;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getDepartment() == department) {
                        System.out.println(String.format("ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[i].getNumber(),
                                employees[i].getFullName(), employees[i].getDepartment(), employees[i].getWage()));
                    }
                }
                break;
            default:
                throw new RuntimeException("Ошибка ввода");

        }
    }
    public int salaryCosts(int way, int department) {
        int costs = 0;
        switch (way) {
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    costs += employees[i].getWage();
                }
                return costs;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getDepartment() == department) {
                        costs += employees[i].getWage();
                    }
                }
                return costs;
            default:
                throw new RuntimeException("Ошибка ввода");
        }
    }
    public void searchMin(int way, int department) {
        double min = employees[0].getWage();
        int index = 0;
        switch (way) {
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getWage()< min) {
                        min = employees[i].getWage();
                        index = i;
                    }
                }
                System.out.println(String.format("Минимальная ЗП - ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[index].getNumber(),
                        employees[index].getFullName(), employees[index].getDepartment(), employees[index].getWage()));
                break;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    if (department == employees[i].getDepartment()) {
                        if (employees[i].getWage()< min) {
                            min = employees[i].getWage();
                            index = i;
                        }
                    }
                }
                System.out.println(String.format("Минимальная ЗП - ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[index].getNumber(),
                        employees[index].getFullName(), employees[index].getDepartment(), employees[index].getWage()));
                break;
            default:
                throw new RuntimeException("Ошибка ввода");
        }
    }
    public void searchMax(int way, int department) {
        double max = employees[0].getWage();
        int index = 0;
        switch (way) {
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getWage() > max) {
                        max = employees[i].getWage();
                        index = i;
                    }
                }
                System.out.println(String.format("Максимальная ЗП - ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[index].getNumber(),
                        employees[index].getFullName(), employees[index].getDepartment(), employees[index].getWage()));
                break;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    if (department == employees[i].getDepartment()) {
                        if (employees[i].getWage() > max) {
                            max = employees[i].getWage();
                            index = i;
                        }
                    }
                }
                System.out.println(String.format("Максимальная ЗП - ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[index].getNumber(),
                        employees[index].getFullName(), employees[index].getDepartment(), employees[index].getWage()));
                break;
            default:
                throw new RuntimeException("Ошибка ввода");
        }
    }
    public void averageSalary(int way, int department) {
        double average;
        double sum = 0;
        switch (way) {
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    sum+= employees[i].getWage();
                }
                average = sum/employees.length;
                System.out.printf("Cредняя ЗП: %s%n", average);
                break;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    if (department == employees[i].getDepartment()) {
                        sum+= employees[i].getWage();
                    }
                }
                average = sum/employees.length;
                System.out.printf("Департамент: %d, Cредняя ЗП: %.2f",department,average);
                break;
            default:
                throw new RuntimeException("Ошибка ввода");
        }
    }
    public void searchId(int idNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getNumber() == idNumber) {
                System.out.println(String.format("ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[i].getNumber(),
                        employees[i].getFullName(), employees[i].getDepartment(), employees[i].getWage()));
            }
        }
    }
    public void salaryIndexing( int way, int number, int department) {
        double percentage = ((double) number / 100) + 1;
        switch (way) {
            case 1:
                for (int i = 0; i < employees.length; i++) {
                    employees[i].setWage((employees[i].getWage() * percentage));
                }
                break;
            case 2:
                for (int i = 0; i < employees.length; i++) {
                    if (department == employees[i].getDepartment()) {
                        employees[i].setWage((employees[i].getWage() * percentage));
                    }
                }
                break;
            default:
                throw new RuntimeException("Ошибка ввода");
        }
    }
    public void salaryCutoff(int salary) {
        System.out.println("а) Сотрудники с зарплатой меньше " + salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getWage() < salary) {
                System.out.println(String.format("ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[i].getNumber(),
                        employees[i].getFullName(), employees[i].getDepartment(), employees[i].getWage()));
            }
        }
        System.out.println();
        System.out.println("б) Сотрудники с зарплатой больше " + salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getWage() > salary) {
                System.out.println(String.format("ID: %d ФИО: %s департамент: %d ЗП: %.2f", employees[i].getNumber(),
                        employees[i].getFullName(), employees[i].getDepartment(), employees[i].getWage()));
            }
        }
        System.out.println();
    }
}
