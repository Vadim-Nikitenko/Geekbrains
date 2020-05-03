package lesson5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("John", "programmer", "john@gmail.com", "+666666", 10000, 30);
        employee.showInfo();

        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivan", "Engineer", "ivan@gmail.com", "+111111", 9000, 35);
        employeeArray[1] = new Employee("Max", "IOS developer", "Max@gmail.com", "+222222", 11000, 26);
        employeeArray[2] = new Employee("Terry", "Android developer", "Terry@gmail.com", "+333333", 11000, 27);
        employeeArray[3] = new Employee("Mike", "QA automation", "Mike@gmail.com", "+444444", 9000, 24);
        employeeArray[4] = new Employee("Kevin", "Data scientist", "Kevin@gmail.com", "+5555555", 10000, 41);
        for (Employee value : employeeArray) {
            if (value.age > 40) {
                value.showInfo();
            }
        }
    }

    public void showInfo() {
        System.out.println(
                "Name: " + name +
                "\nPosition: " + position +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nSalary: " + salary +
                "\nAge: " + age + "\n");
    }
}
