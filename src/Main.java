public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иванов", "Иван", "Иванович", 1, 3200);
        employeeBook.addEmployee("Петров", "Иван", "Иванович", 4, 3500);
        employeeBook.addEmployee("Сидоров", "Игорь", "Иванович", 2, 4500);
        employeeBook.addEmployee("Сидоров", "Иван", "Петрович", 2, 4400);
        employeeBook.addEmployee("Смирнов", "Игорь", "Сергеевич", 5, 4700);
        employeeBook.addEmployee("Хачатрян", "Абдул", "Иманхетович", 3, 4500);
        employeeBook.addEmployee("Афанасьев", "Антон", "Александрович", 3, 5500);
        employeeBook.addEmployee("Игнатьев", "Игорь", "Сергеевич", 1, 4000);
        employeeBook.addEmployee("Самаров", "Александр", "Иванович", 5, 4200);
        employeeBook.addEmployee("Игнатьев", "Алексей", "Сергеевич", 4, 3700);
        System.out.println("Базовая сложность.");
        System.out.println("**************************************************");
        employeeBook.getAllEmployees();
        System.out.println("-----------------------------------------------");
        System.out.printf("Сумма затрат на зарплаты в месяц: %.2f рублей.", employeeBook.getSumSalaryPerMonth());
        System.out.println("-----------------------------------------------");
        System.out.println("Сотрудник с минимальной зарплатой - " + employeeBook.getMinSalary());
        System.out.println("-----------------------------------------------");
        System.out.println("Сотрудник с максимальной зарплатой - " + employeeBook.getMaxSalary());
        System.out.println("-----------------------------------------------");
        System.out.printf("Среднее значение зарплат: %.2f рублей.", employeeBook.getAverageSalary());
        System.out.println("-----------------------------------------------");
        employeeBook.getFioEmployees();
        System.out.println("-----------------------------------------------");
        System.out.println("Повышенная сложность.");
        System.out.println("**************************************************");
        employeeBook.getIndexSalary();
        System.out.println();
        System.out.println("-----------------------------------------------");
        int departmentNumber = 5;
        System.out.println("Сотрудник с минимальной зарплатой в отделе № "+ departmentNumber +" - " + employeeBook.getMinDepartmentSalary(departmentNumber));
        System.out.println("-----------------------------------------------");
        System.out.println("Сотрудник с максимальной зарплатой в отделе № "+ departmentNumber +" - " + employeeBook.getMaxDepartmentSalary(departmentNumber));
        System.out.println("-----------------------------------------------");
        System.out.printf("Сумма затрат на зарплаты в месяц: в отделе № " + departmentNumber + " - %.2f рублей.", employeeBook.getSumSalaryDepartmentPerMonth(departmentNumber));
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.printf("Среднее значение зарплат: в отделе № " + departmentNumber +" - %.2f рублей.", employeeBook.getAverageSalaryDepartment(departmentNumber));
        System.out.println();
        System.out.println("-----------------------------------------------");
        int procent = 10;
        employeeBook.getIndexSalaryDepartment(departmentNumber, procent);
        System.out.println("-----------------------------------------------");
        employeeBook.getAllEmployeesDepartment(departmentNumber);
        System.out.println("-----------------------------------------------");
        double EmployeesSalary = 4500.00d;
        employeeBook.getAllEmployeesSalaryMin(EmployeesSalary);
        System.out.println("-----------------------------------------------");
        employeeBook.getAllEmployeesSalaryMax(EmployeesSalary);
        System.out.println(" ");
        String fioEmployees = "Калинин Марк Архипович";
        employeeBook.getNewSalaryDepartmentEmployee(fioEmployees, EmployeesSalary, departmentNumber);
        System.out.println(" ");
        System.out.println(" ");
        employeeBook.removeEmployee(4);
        System.out.println(" ");
        employeeBook.getAllEmployeesDepartment();
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






