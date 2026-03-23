package Ex1;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo danh sách chứa các đối tượng Animals
        List<Animals> animalList = new ArrayList<>();

        // Thêm Dog và Cat vào danh sách (Tính đa hình)
        animalList.add(new Dog("Buddy", 3, "Golden Retriever"));
        animalList.add(new Cat("Kitty", 2, "Trắng"));
        animalList.add(new Dog("", -1, "Husky")); // Thử nghiệm dữ liệu lỗi

        System.out.println("--- THÔNG TIN DANH SÁCH ĐỘNG VẬT ---");
        for (Animals a : animalList) {
            a.displayInfo();
            System.out.println("Tiếng kêu: " + a.makeSound());
            System.out.println("-------------------------");
        }
    }
}
