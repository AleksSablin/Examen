public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов", "Иван", "Иванович", 1, 3200);
        employees[1] = new Employee("Петров", "Иван", "Иванович", 4, 3500);
        employees[2] = new Employee("Сидоров", "Игорь", "Иванович", 2, 4500);
        employees[3] = new Employee("Сидоров", "Иван", "Петрович", 2, 4400);
        employees[4] = new Employee("Смирнов", "Игорь", "Сергеевич", 5, 4700);
        employees[5] = new Employee("Хачатрян", "Абдул", "Иманхетович", 3, 4500);
        employees[6] = new Employee("Афанасьев", "Антон", "Александрович", 3, 5500);
        employees[7] = new Employee("Игнатьев", "Игорь", "Сергеевич", 1, 4000);
        employees[8] = new Employee("Самаров", "Александр", "Иванович", 5, 4200);
        employees[9] = new Employee("Игнатьев", "Алексей", "Сергеевич", 4, 3700);
        System.out.println("Базовая сложность.");
        System.out.println("**************************************************");
        all();
        System.out.println("-----------------------------------------------");
        System.out.println("Всего затрат на зарплату: " + getSumSalaryPerMonth());
        System.out.println("-----------------------------------------------");
        System.out.println("Минимальная зарплата у сотрудника: " + getMinSalary());
        System.out.println("-----------------------------------------------");
        System.out.println("Максимальная зарплата у сотрудника: " + getMaxSalary());
        System.out.println("-----------------------------------------------");
        System.out.println("Средняя зарплата сотрудников: " + averageValueSalary());
        System.out.println("-----------------------------------------------");
        getFullName();
        System.out.println("-----------------------------------------------");
        System.out.println("Повышенная сложность.");
        System.out.println("**************************************************");
        getIndexSalary();
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Сотрудник с минимальной зарплатой - " + getMinDepartmentSalary(2));
        System.out.println("-----------------------------------------------");
        System.out.println("Сотрудник с максимальной зарплатой - " + getMaxDepartmentSalary(2));
        System.out.println("-----------------------------------------------");
        int departmentNumber = 1;
        System.out.printf("Сумма затрат на зарплаты в месяц: в отделе № " + departmentNumber + " - %.2f рублей.", getSumSalaryDepartmentPerMonth(departmentNumber));
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.printf("Среднее значение зарплат: в отделе № " + departmentNumber +" - %.2f рублей.", getAverageSalaryDepartment(departmentNumber));
        System.out.println();
        System.out.println("-----------------------------------------------");
        getIndexSalaryDepartment(departmentNumber);
        System.out.println("-----------------------------------------------");
        getAllEmployeesDepartment(departmentNumber);
        System.out.println("-----------------------------------------------");
        double EmployeesSalary = 4500.00d;
        getAllEmployeesSalaryMin(EmployeesSalary);
        System.out.println("-----------------------------------------------");
        getAllEmployeesSalaryMax(EmployeesSalary);
    }

    public static void all() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    public static double getSumSalaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee getMinSalary() {
        double min = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                min = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    public static Employee getMaxSalary() {
        double max = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee maxSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    public static double averageValueSalary() {
        double sum = getSumSalaryPerMonth();
        int count = countEmployees();
        return sum / count;
    }

    public static int countEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public static void getFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public static Employee getIndexSalary() {
        int arg = 10;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * arg / 100);
                System.out.print(employee.getSalary() + "\t");
            }
        }
        return null;
    }

    public static Employee getMinDepartmentSalary(int departmentNumber) {
        double min = 0;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                min = employees[i].getSalary();
                index = i;
                break;
            }
        }

        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min && employees[i].getDepartment() == departmentNumber) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    public static Employee getMaxDepartmentSalary(int departmentNumber) {
        double max = 0;
        int index = 0;
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
                index = i;
                break;
            }
        }

        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max && employees[i].getDepartment() == departmentNumber) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    public static double getSumSalaryDepartmentPerMonth(int departmentNumber) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == departmentNumber) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public static double getAverageSalaryDepartment(int departmentNumber) {
        double sum = 0;
        int countEmp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == departmentNumber) {
                countEmp++;
                sum += employees[i].getSalary();
            }
        }

        return sum / countEmp;
    }

        public static void getIndexSalaryDepartment(int departmentNumber) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == departmentNumber) {
                    employee.setSalary(employee.getSalary() + employee.getSalary() * departmentNumber / 100);
                    System.out.println(employee.getSalary());
                }
            }
        }

        public static void getAllEmployeesDepartment(int departmentNumber) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == departmentNumber) {
                    System.out.println("Информация о сотруднике: (ID = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
                }
            }
        }

        public static void getAllEmployeesSalaryMin(double EmployeesSalary) {
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() < EmployeesSalary) {
                    System.out.println("Информация о сотруднике: (ID = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
                }
            }
        }

        public static void getAllEmployeesSalaryMax(double EmployeesSalary) {
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() >= EmployeesSalary) {
                    System.out.println("Информация о сотруднике: (ID = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
                }
            }
    }
}






