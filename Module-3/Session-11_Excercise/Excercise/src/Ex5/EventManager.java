package Ex5;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EventManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Event> events = new ArrayList<>();
        // Định dạng: ngày-tháng-năm giờ:phút
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        while (true) {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) break;
            
            if (name.isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            LocalDateTime start = null;
            LocalDateTime end = null;

            // Vòng lặp nhập thời gian bắt đầu
            while (start == null) {
                System.out.print("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");
                String startStr = sc.nextLine();
                try {
                    start = LocalDateTime.parse(startStr, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            // Vòng lặp nhập thời gian kết thúc
            while (end == null) {
                System.out.print("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm): ");
                String endStr = sc.nextLine();
                try {
                    end = LocalDateTime.parse(endStr, formatter);
                    // Kiểm tra logic: ngày kết thúc phải sau ngày bắt đầu
                    if (end.isBefore(start)) {
                        System.out.println("Ngày kết thúc phải sau ngày bắt đầu!");
                        end = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            events.add(new Event(name, start, end));
            System.out.println("------------------------------------------------");
        }

        // In danh sách kết quả
        System.out.println("\nDanh sách sự kiện:");
        events.forEach(System.out::println);
    }
}
