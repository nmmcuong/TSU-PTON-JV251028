package Ex8;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    // Constructors
    public Student() {}

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Phương thức nhập dữ liệu
    public void inputData(Scanner sc) {
        System.out.print("Nhập mã HS: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên HS: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(sc.nextLine());
        
        System.out.println("Chọn giới tính (1. MALE, 2. FEMALE, 3. OTHER): ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1 -> this.gender = Gender.MALE;
            case 2 -> this.gender = Gender.FEMALE;
            default -> this.gender = Gender.OTHER;
        }
        
        System.out.print("Nhập địa chỉ: ");
        this.address = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = sc.nextLine();
    }

    // Phương thức hiển thị dữ liệu
    public void displayData() {
        System.out.printf("ID: %-5d | Tên: %-15s | Tuổi: %-3d | Giới tính: %-8s | ĐC: %-10s | SĐT: %-10s\n", 
                          id, name, age, gender, address, phoneNumber);
    }
}
