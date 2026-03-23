package Ex3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo đối tượng Person thứ nhất
        Person p1 = new Person();
        System.out.println("Nhập thông tin người thứ nhất:");
        System.out.print("Tên: ");
        p1.setName(scanner.nextLine());
        System.out.print("Tuổi: ");
        p1.setAge(Integer.parseInt(scanner.nextLine()));

        // Tạo đối tượng Person thứ hai
        Person p2 = new Person();
        System.out.println("\nNhập thông tin người thứ hai:");
        System.out.print("Tên: ");
        p2.setName(scanner.nextLine());
        System.out.print("Tuổi: ");
        p2.setAge(Integer.parseInt(scanner.nextLine()));

        // So sánh tuổi và in kết quả
        System.out.println("\n--- Kết quả so sánh ---");
        if (p1.getAge() > p2.getAge()) {
            System.out.println(p1.getName() + " lớn tuổi hơn " + p2.getName());
        } else if (p1.getAge() < p2.getAge()) {
            System.out.println(p2.getName() + " lớn tuổi hơn " + p1.getName());
        } else {
            System.out.println(p1.getName() + " và " + p2.getName() + " bằng tuổi nhau.");
        }

        scanner.close();
    }
}
