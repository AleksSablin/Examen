public class Employee {

    private String SurName;

    private String Name;

    private String Patronymic;

    private int Department;

    private int Salary;

    private final int id;

    private static int counter;

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public int getDepartment() {
        return Department;
    }

    public void setDepartment(int department) {
        this.Department = department;
        if (department > 0 || department <= 5);
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public Employee(String surName, String name, String patronymic, int department, int salary) {
        if (department < 1 || department > 5)
            throw new IllegalArgumentException("Введено невалидное значение department");
        counter++;
        this.SurName = surName;
        this.Name = name;
        this.Patronymic = patronymic;
        this.Department = department;
        this.Salary = salary;
        this.id = getCounter();
    }

    @Override
    public String toString() {
        return "" +
                "Фамилия-" + SurName + "," +
                " Имя-" + Name + "," +
                " Отчество-" + Patronymic + "," +
                " Отдел-" + Department + ":" +
                " Зарплата в месяц-" + Salary +
                " id=" + id +
                "";
    }
    public String getFullName(){
        return getSurName() + " " +getName() + " " + getPatronymic();
        }
    }


