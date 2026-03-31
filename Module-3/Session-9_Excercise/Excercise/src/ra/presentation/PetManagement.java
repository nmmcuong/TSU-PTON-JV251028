package ra.presentation;

import ra.entity.Pet;
import ra.entity.Dog;
import ra.entity.Cat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetManagement {
    private static List<Pet> petList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("\n********************QUẢN LÝ THÚ CƯNG********************");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng theo mã");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: displayAll(); break;
                case 2: addPet(); break;
                case 3: makeSomeNoise(); break;
                case 4: deletePet(); break;
                case 5: searchByName(); break;
                case 6: System.exit(0);
            }
        } while (true);
    }

    private static void displayAll() {
        if (petList.isEmpty()) System.out.println("Danh sách trống!");
        for (Pet p : petList) {
            p.displayData();
            p.speak(); // Hiển thị kèm tiếng kêu
        }
    }

    private static void addPet() {
        System.out.println("Bạn muốn thêm: 1. Chó | 2. Mèo");
        int type = Integer.parseInt(scanner.nextLine());
        Pet newPet = (type == 1) ? new Dog() : new Cat();
        newPet.inputData(scanner, petList);
        petList.add(newPet);
        System.out.println("Thêm thành công!");
    }

    private static void makeSomeNoise() {
        for (Pet p : petList) {
            System.out.print(p.getPetName() + " kêu: ");
            p.speak();
        }
    }

    private static void deletePet() {
        System.out.print("Nhập mã thú cưng cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = petList.removeIf(p -> p.getPetId().equalsIgnoreCase(id));
        System.out.println(removed ? "Xóa thành công!" : "Không tìm thấy mã này.");
    }

    private static void searchByName() {
        System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        petList.stream()
               .filter(p -> p.getPetName().toLowerCase().contains(name))
               .forEach(Pet::displayData);
    }
}
