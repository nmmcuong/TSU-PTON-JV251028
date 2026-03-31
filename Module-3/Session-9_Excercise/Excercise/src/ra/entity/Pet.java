package ra.entity;

import java.util.List;
import java.util.Scanner;

public abstract class Pet {
    private String petId;
    private String petName;
    private int age;

    public Pet() {}

    public Pet(String petId, String petName, int age) {
        this.petId = petId;
        this.petName = petName;
        this.age = age;
    }

    // Getters and Setters
    public String getPetId() { return petId; }
    public void setPetId(String petId) { this.petId = petId; }
    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Phương thức nhập dữ liệu có kiểm tra ràng buộc (Validation)
    public void inputData(Scanner scanner, List<Pet> petList) {
        // 1. Validate ID: C hoặc D + 3 số, không trùng lặp
        while (true) {
            System.out.print("Nhập mã thú cưng (Cxxx hoặc Dxxx): ");
            String id = scanner.nextLine();
            if (id.matches("^[CD]\\d{3}$")) {
                boolean isExist = false;
                for (Pet p : petList) {
                    if (p.getPetId().equals(id)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    this.petId = id;
                    break;
                } else {
                    System.err.println("Mã thú cưng đã tồn tại!");
                }
            } else {
                System.err.println("Mã không đúng định dạng (VD: C001, D123)!");
            }
        }

        // 2. Validate Name: 20-50 ký tự
        while (true) {
            System.out.print("Nhập tên thú cưng (20-50 ký tự): ");
            this.petName = scanner.nextLine();
            if (this.petName.length() >= 20 && this.petName.length() <= 50) {
                break;
            }
            System.err.println("Tên phải từ 20 đến 50 ký tự!");
        }

        // 3. Validate Age: > 0
        while (true) {
            try {
                System.out.print("Nhập tuổi: ");
                this.age = Integer.parseInt(scanner.nextLine());
                if (this.age > 0) break;
                else System.err.println("Tuổi phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    public void displayData() {
        System.out.printf("ID: %-5s | Tên: %-30s | Tuổi: %-3d | ", petId, petName, age);
    }

    public abstract void speak();
}
