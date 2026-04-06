package Ex3;

import java.util.*;
import java.util.stream.Collectors;

import Ex3.Order;

public class OrderBusiness {
    public static List<Order> listOrder = new ArrayList<>();
    private static int nextId = 1;

    public static void addOrder(Scanner scanner) {
        Order order = new Order();
        order.setOrderId(nextId++);
        order.inputData(scanner);
        listOrder.add(order);
        System.out.println("Thêm đơn hàng thành công!");
    }

    public static void displayOrders() {
        listOrder.stream()
                .sorted(Comparator.comparingDouble(Order::getOrderAmount).reversed())
                .forEach(System.out::println);
    }

    public static void updateStatus(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        listOrder.stream().filter(o -> o.getOrderId() == id).findFirst().ifPresentOrElse(o -> {
            System.out.print("Nhập trạng thái mới (1. Shipped, 2. Delivered): ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) o.setStatus("Shipped");
            else if (choice == 2) o.setStatus("Delivered");
            System.out.println("Cập nhật thành công!");
        }, () -> System.err.println("Không tìm thấy mã đơn hàng!"));
    }

    public static void deleteOrder(Scanner scanner) {
        System.out.print("Nhập mã đơn hàng cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = listOrder.removeIf(o -> o.getOrderId() == id && o.getStatus().equals("Pending"));
        if (removed) System.out.println("Xóa thành công!");
        else System.err.println("Không thể xóa (Chỉ xóa đơn hàng ở trạng thái Pending)!");
    }

    public static void findMaxOrder() {
        listOrder.stream()
                .max(Comparator.comparingDouble(Order::getOrderAmount))
                .ifPresentOrElse(o -> System.out.println("Đơn hàng lớn nhất: " + o),
                        () -> System.out.println("Danh sách trống!"));
    }

    // Các hàm thống kê
    public static void countOrders() { System.out.println("Tổng số đơn: " + listOrder.size()); }
    
    public static void sumDeliveredAmount() {
        double total = listOrder.stream()
                .filter(o -> o.getStatus().equals("Delivered"))
                .mapToDouble(Order::getOrderAmount).sum();
        System.out.println("Tổng doanh thu (Delivered): " + total);
    }

    public static void countByStatus() {
        Map<String, Long> stats = listOrder.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        stats.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
