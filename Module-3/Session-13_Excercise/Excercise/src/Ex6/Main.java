package Ex6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n======== TO-DO LIST MENU ========");
            System.out.println("1. Thêm công việc");
            System.out.println("2. Liệt kê danh sách");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa công việc");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                String input = sc.nextLine();
                if (input.isEmpty()) continue;
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.print("Tên công việc: ");
                        String name = sc.nextLine();
                        if (name.trim().isEmpty()) {
                            System.err.println("Tên không được để trống!");
                            break;
                        }
                        System.out.print("Trạng thái (1: Chưa hoàn thành, 2: Đã hoàn thành): ");
                        String st = sc.nextLine().equals("2") ? "đã hoàn thành" : "chưa hoàn thành";
                        tm.addTask(name, st);
                        break;
                    case 2:
                        tm.listTasks();
                        break;
                    case 3:
                        System.out.print("Nhập ID cần sửa: ");
                        int idU = Integer.parseInt(sc.nextLine());
                        System.out.print("Trạng thái mới (1: Chưa hoàn thành, 2: Đã hoàn thành): ");
                        String stU = sc.nextLine().equals("2") ? "đã hoàn thành" : "chưa hoàn thành";
                        tm.updateTaskStatus(idU, stU);
                        break;
                    case 4:
                        System.out.print("Nhập ID cần xóa: ");
                        int idD = Integer.parseInt(sc.nextLine());
                        tm.deleteTask(idD);
                        break;
                    case 5:
                        System.out.print("Nhập tên cần tìm: ");
                        tm.searchTaskByName(sc.nextLine());
                        break;
                    case 6:
                        tm.taskStatistics();
                        break;
                    case 7:
                        System.out.println("Tạm biệt!");
                        System.exit(0);
                    default:
                        System.err.println("Vui lòng chọn từ 1-7.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số!");
            } catch (Exception e) {
                System.err.println("Đã có lỗi xảy ra: " + e.getMessage());
            }
        }
    }
}
