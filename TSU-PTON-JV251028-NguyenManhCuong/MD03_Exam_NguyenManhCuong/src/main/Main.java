package main;
import DAO.DegreeDAO;
import entity.Degree;
import service.DegreeService;

import java.sql.Timestamp;
import java.time.Year;
import java.util.List;
import java.util.Scanner;
public class Main {
	private final Scanner sc = new Scanner(System.in);
	public final  DegreeService sv = new DegreeService();
	public static void main(String[] args) {
		
	}
	
	public void start () {
        int choice;
        do {
            System.out.println("********* DEGREES MANAGEMENT *********");
            System.out.println("1. Danh sách các bằng cấp");
            System.out.println("2. Thêm mới một bằng cấp");
            System.out.println("3. Cập nhật bằng cấp");
            System.out.println("4. Xóa bằng cấp");
            System.out.println("5. Tìm kiếm bằng cấp theo tên");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1 -> sv.showAll();
                    case 2 -> sv.add();
                    case 3 -> sv.update();
                    case 4 -> sv.delete();
                    case 5 -> sv.search();
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (choice != 6);
    }
}
