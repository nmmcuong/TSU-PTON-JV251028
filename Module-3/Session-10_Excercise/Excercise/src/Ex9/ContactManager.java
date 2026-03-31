package Ex9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactManager {
    public static void main(String[] args) {
        Set<Contact> contacts = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        // Demo thêm liên lạc
        addContact(contacts, new Contact("Nguyễn Văn A", "0123456789"));
        addContact(contacts, new Contact("Trần Thị B", "0987654321"));
        addContact(contacts, new Contact("Lặp lại", "0123456789")); // Sẽ báo lỗi

        System.out.println("\nDanh sách danh bạ:");
        contacts.forEach(System.out::println);
    }

    public static void addContact(Set<Contact> set, Contact c) {
        if (!set.add(c)) {
            System.out.println("Lỗi: Số điện thoại " + c.getPhoneNumber() + " đã tồn tại!");
        } else {
            System.out.println("Thêm thành công: " + c.getPhoneNumber());
        }
    }
}