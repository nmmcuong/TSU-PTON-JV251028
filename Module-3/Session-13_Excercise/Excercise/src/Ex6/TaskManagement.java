package Ex6;

import java.sql.*;

import db6.DBConnection;

public class TaskManagement {
    
    public void addTask(String taskName, String status) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call add_task(?, ?)}")) {
            cs.setString(1, taskName);
            cs.setString(2, status);
            cs.executeUpdate();
            System.out.println("Thêm công việc thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi thêm công việc: " + e.getMessage());
        }
    }

    public void listTasks() {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call list_tasks()}");
             ResultSet rs = cs.executeQuery()) {
            System.out.println("\n--- DANH SÁCH CÔNG VIỆC ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %-25s | Trạng thái: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi hiển thị: " + e.getMessage());
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call update_task_status(?, ?)}")) {
            cs.setInt(1, taskId);
            cs.setString(2, status);
            int row = cs.executeUpdate();
            if (row > 0) System.out.println("Cập nhật trạng thái thành công!");
            else System.out.println("Không tìm thấy ID công việc.");
        } catch (SQLException e) {
            System.err.println("Lỗi cập nhật: " + e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call delete_task(?)}")) {
            cs.setInt(1, taskId);
            cs.executeUpdate();
            System.out.println("Đã xóa công việc!");
        } catch (SQLException e) {
            System.err.println("Lỗi xóa: " + e.getMessage());
        }
    }

    public void searchTaskByName(String taskName) {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call search_task_by_name(?)}")) {
            cs.setString(1, taskName);
            ResultSet rs = cs.executeQuery();
            System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Tên: %-25s | Trạng thái: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi tìm kiếm: " + e.getMessage());
        }
    }

    public void taskStatistics() {
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall("{call task_statistics()}");
             ResultSet rs = cs.executeQuery()) {
            System.out.println("\n--- THỐNG KÊ ---");
            while (rs.next()) {
                System.out.println(rs.getString("status") + ": " + rs.getInt("total") + " công việc");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi thống kê: " + e.getMessage());
        }
    }
}
