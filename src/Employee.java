public class Employee {
    private String fullName;
    private int department;
    private double wage;
    private int number;

    public Employee (String fullName, int department, int wage) {
        this.fullName=fullName;
        this.department=department;
        this.wage=wage;
        this.number = Counter.getAndIncrement();
        ;
    }

    public int getNumber() {
        return number;
    }
    public String getFullName() {
        return this.fullName;
    }
    public int getDepartment() {
        return this.department;
    }
    public double getWage() {
        return  this.wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
}
