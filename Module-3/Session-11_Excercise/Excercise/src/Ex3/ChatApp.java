package Ex3;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Message> chatHistory = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.print("Nhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine();
            if (sender.equalsIgnoreCase("exit")) break;

            System.out.print("Nhập nội dung tin nhắn: ");
            String content = scanner.nextLine();
            
            // Lưu tin nhắn với ngày hiện tại
            chatHistory.add(new Message(sender, content, LocalDate.now()));

            System.out.println("Nhập 'history' để xem lịch sử, 'filter' để lọc theo người gửi, 'date' để lọc theo ngày:");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "history":
                    System.out.println("--- Lịch sử chat ---");
                    chatHistory.forEach(System.out::println);
                    break;

                case "filter":
                    System.out.print("Nhập tên người gửi cần lọc: ");
                    String filterSender = scanner.nextLine();
                    System.out.println("--- Tin nhắn của " + filterSender + " ---");
                    chatHistory.stream()
                        .filter(m -> m.getSender().equalsIgnoreCase(filterSender))
                        .forEach(System.out::println);
                    break;

                case "date":
                    System.out.print("Nhập ngày (dd-MM-yyyy): ");
                    String dateInput = scanner.nextLine();
                    try {
                        LocalDate filterDate = LocalDate.parse(dateInput, dateFormatter);
                        System.out.println("--- Tin nhắn ngày " + dateInput + " ---");
                        chatHistory.stream()
                            .filter(m -> m.getTimestamp().equals(filterDate))
                            .forEach(System.out::println);
                    } catch (DateTimeParseException e) {
                        System.out.println("Lỗi: Định dạng ngày không hợp lệ! Vui lòng nhập theo dạng dd-MM-yyyy.");
                    }
                    break;

                default:
                    System.out.println("Tiếp tục nhắn tin...");
                    break;
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println("Ứng dụng đã thoát.");
    }
}
