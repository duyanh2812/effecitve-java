package Chapter_1_CreateAndDestroyObject;/*
Tên rõ ràng: Giúp dễ hiểu hơn so với constructor.
Tái sử dụng logic: Có thể chứa logic để tạo đối tượng tùy chỉnh.
Kiểm soát tốt hơn: Có thể trả về một đối tượng cache, singleton, hoặc subclass nếu cần.
Không bị giới hạn bởi số lượng constructor: Dễ dàng thêm các phương thức tạo mới mà không gây xung đột.
 */

public class Item_1_StaticFactory{
    public static void main(String[] args) {
        // Create CreateAndDestroyObject.Employee objects using static factory methods
        Employee emp1 = Employee.of("Alice", 30, "Engineering");
        Employee emp2 = Employee.withDefaultDepartment("Bob", 25);
        Employee emp3 = Employee.intern("Charlie");

        // Print the employees
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
    }
}
class Employee {
    private final String name;
    private final int age;
    private final String department;

    // Private constructor to prevent direct instantiation
    private Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Static factory methods
    public static Employee of(String name, int age, String department) {
        return new Employee(name, age, department);
    }

    public static Employee withDefaultDepartment(String name, int age) {
        return new Employee(name, age, "General");
    }

    public static Employee intern(String name) {
        return new Employee(name, 18, "Internship");
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "CreateAndDestroyObject.Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }


}