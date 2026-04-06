package Ex2;

import Ex2.AppointmentBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n********************QUẢN LÝ LỊCH HẸN********************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách (Sắp xếp theo ngày)");
            System.out.println("3. Tìm kiếm theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã");
            System.out.println("5. Xóa lịch hẹn theo mã");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: AppointmentBusiness.addAppointment(scanner); break;
                    case 2: AppointmentBusiness.displayAll(); break;
                    case 3: AppointmentBusiness.searchByName(scanner); break;
                    case 4: AppointmentBusiness.updateAppointment(scanner); break;
                    case 5: AppointmentBusiness.deleteAppointment(scanner); break;
                    case 6: AppointmentBusiness.showStats(); break;
                    case 7: System.exit(0);
                    default: System.err.println("Vui lòng chọn 1-7!");
                }
            } catch (Exception e) {
                System.err.println("Đầu vào không hợp lệ!");
            }
        }
    }
}
