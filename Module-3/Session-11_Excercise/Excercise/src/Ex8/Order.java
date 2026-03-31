package Ex8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Order {
    private int id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    // Constructor đầy đủ
    public Order(int id, String customerName, LocalDate createdDate, LocalDate deliveryDate) {
        this.id = id;
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    // Getters
    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public LocalDate getCreatedDate() { return createdDate; }
    public Optional<LocalDate> getDeliveryDate() { return deliveryDate; }

    // Phương thức hiển thị theo yêu cầu
    public String toDisplayString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String deliveryStr = deliveryDate
                .map(date -> date.format(dtf))
                .orElse("Chưa giao");
        
        return String.format("ID: %d | Tên KH: %-10s | Ngày đặt: %s | Ngày giao: %s", 
                id, customerName, createdDate.format(dtf), deliveryStr);
    }
}
