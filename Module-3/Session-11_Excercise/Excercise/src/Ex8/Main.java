package Ex8;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo danh sách đơn hàng
        List<Order> orders = List.of(
            new Order(1, "Quý", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 25)),
            new Order(2, "Lan", LocalDate.of(2025, 3, 21), null),
            new Order(3, "Minh", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 23)),
            new Order(4, "Huyền", LocalDate.of(2025, 3, 23), null),
            new Order(5, "Việt", LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 30))
        );

        // 2. Liệt kê các đơn hàng đã được giao
        System.out.println("--- Đơn hàng đã giao ---");
        orders.stream()
            .filter(o -> o.getDeliveryDate().isPresent())
            .forEach(o -> System.out.println(o.toDisplayString()));

        // 3. Liệt kê các đơn hàng chưa được giao
        System.out.println("\n--- Đơn hàng chưa giao ---");
        orders.stream()
            .filter(o -> o.getDeliveryDate().isEmpty())
            .forEach(o -> System.out.println(o.toDisplayString()));

        // 4. Đếm số đơn hàng đã giao từ ngày 2025-03-17 đến 2025-03-23
        LocalDate start = LocalDate.of(2025, 3, 17);
        LocalDate end = LocalDate.of(2025, 3, 23);
        
        long count = orders.stream()
            .filter(o -> o.getDeliveryDate().isPresent())
            .filter(o -> {
                LocalDate dDate = o.getDeliveryDate().get();
                return (dDate.isEqual(start) || dDate.isAfter(start)) && 
                       (dDate.isEqual(end) || dDate.isBefore(end));
            })
            .count();

        System.out.println("\nSố đơn hàng đã giao trong khoảng 17/03 đến 23/03: " + count);
    }
}
