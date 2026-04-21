package Ex9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management mg = new Management();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== QUẢN LÝ CÔNG TY =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Thêm dự án");
            System.out.println("3. Gán nhân viên vào dự án");
            System.out.println("4. Xem danh sách phân công");
            System.out.println("5. Cập nhật lương nhân viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Tên NV: "); String name = sc.nextLine();
                    System.out.print("Phòng ban: "); String dep = sc.nextLine();
                    System.out.print("Lương: "); double sal = Double.parseDouble(sc.nextLine());
                    mg.addEmployee(new Employee(name, dep, sal));
                    break;
                case 2:
                    System.out.print("Tên dự án: "); String pName = sc.nextLine();
                    System.out.print("Ngân sách: "); double bud = Double.parseDouble(sc.nextLine());
                    mg.addProject(new Project(pName, bud));
                    break;
                case 3:
                    System.out.print("Mã NV: "); int eid = Integer.parseInt(sc.nextLine());
                    System.out.print("Mã dự án: "); int pid = Integer.parseInt(sc.nextLine());
                    System.out.print("Vai trò: "); String role = sc.nextLine();
                    mg.assignEmployeeToProject(eid, pid, role);
                    break;
                case 4:
                    mg.listEmployeesAndProjects();
                    break;
                case 5:
                    System.out.print("Mã NV cần cập nhật: "); int uid = Integer.parseInt(sc.nextLine());
                    System.out.print("Lương mới: "); double nSal = Double.parseDouble(sc.nextLine());
                    mg.updateEmployeeSalary(uid, nSal);
                    break;
                case 0:
                    return;
            }
        }
    }
}
