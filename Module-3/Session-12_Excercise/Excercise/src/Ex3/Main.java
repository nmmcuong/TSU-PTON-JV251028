package Ex3;

import java.util.Scanner;

import Ex3.OrderBusiness;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n********************QUẢN LÝ ĐƠN HÀNG********************");
            System.out.println("1. Thêm đơn hàng       2. Hiển thị danh sách      3. Cập nhật trạng thái");
            System.out.println("4. Xóa đơn hàng        5. Tìm kiếm theo tên       6. Tổng số đơn hàng");
            System.out.println("7. Doanh thu Delivered 8. Thống kê trạng thái     9. Đơn hàng lớn nhất");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: OrderBusiness.addOrder(scanner); break;
                case 2: OrderBusiness.displayOrders(); break;
                case 3: OrderBusiness.updateStatus(scanner); break;
                case 4: OrderBusiness.deleteOrder(scanner); break;
                case 6: OrderBusiness.countOrders(); break;
                case 7: OrderBusiness.sumDeliveredAmount(); break;
                case 8: OrderBusiness.countByStatus(); break;
                case 9: OrderBusiness.findMaxOrder(); break;
                case 10: System.exit(0);
            }
        }
    }
}
