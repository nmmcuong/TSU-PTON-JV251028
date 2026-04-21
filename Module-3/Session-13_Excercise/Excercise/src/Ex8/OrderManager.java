package Ex8;

import java.util.ArrayList;
import java.util.List;

class OrderManager {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    // Chức năng 1: Thêm sản phẩm
    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                System.out.println("=> Lỗi: Sản phẩm '" + product.getName() + "' đã tồn tại!");
                return;
            }
        }
        products.add(product);
        System.out.println("=> Thêm sản phẩm thành công.");
    }

    // Chức năng 2: Cập nhật khách hàng
    public void updateCustomer(int customerId, String newName, String newEmail) {
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                c.setName(newName);
                c.setEmail(newEmail);
                System.out.println("=> Cập nhật khách hàng thành công.");
                return;
            }
        }
        System.out.println("=> Lỗi: Không tìm thấy khách hàng ID: " + customerId);
    }

    // Chức năng 3: Tạo đơn hàng (Logic đơn giản hóa)
    public void createOrder(Order order, double amount) {
        order.setTotalAmount(amount);
        orders.add(order);
        System.out.println("=> Tạo đơn hàng mới thành công.");
    }

    // Chức năng 4: Hiển thị danh sách đơn hàng
    public void lastOrders() {
        if (orders.isEmpty()) {
            System.out.println("=> Danh sách đơn hàng trống.");
            return;
        }
        for (Order o : orders) System.out.println(o);
    }

    // Chức năng 5: Tìm đơn hàng theo khách hàng
    public void getOrderByCustomer(int customerId) {
        boolean found = false;
        for (Order o : orders) {
            if (o.getCustomerId() == customerId) {
                System.out.println(o);
                found = true;
            }
        }
        if (!found) System.out.println("=> Không tìm thấy đơn hàng của khách hàng ID: " + customerId);
    }

    // Hỗ trợ thêm khách hàng mẫu
    public void addSampleCustomer(Customer c) { customers.add(c); }
}
