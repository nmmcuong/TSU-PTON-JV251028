package Ex9;

import java.sql.*;

public class Management {
    private final String URL = "jdbc:mysql://localhost:3306/CompanyDB";
    private final String USER = "root"; 
    private final String PASS = "123456"; // Thay bằng mật khẩu của bạn

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // 1. Thêm nhân viên mới
    public void addEmployee(Employee emp) {
        try (Connection conn = getConnection()) {
            String checkSql = "SELECT id FROM Employee WHERE name = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            psCheck.setString(1, emp.name);
            if (psCheck.executeQuery().next()) {
                System.out.println("=> Lỗi: Nhân viên đã tồn tại!");
                return;
            }
            String sql = "INSERT INTO Employee(name, department, salary) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.name);
            ps.setString(2, emp.department);
            ps.setDouble(3, emp.salary);
            ps.executeUpdate();
            System.out.println("=> Thêm nhân viên thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 2. Thêm dự án mới
    public void addProject(Project proj) {
        try (Connection conn = getConnection()) {
            String checkSql = "SELECT id FROM Project WHERE name = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            psCheck.setString(1, proj.name);
            if (psCheck.executeQuery().next()) {
                System.out.println("=> Lỗi: Dự án đã tồn tại!");
                return;
            }
            String sql = "INSERT INTO Project(name, budget) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, proj.name);
            ps.setDouble(2, proj.budget);
            ps.executeUpdate();
            System.out.println("=> Thêm dự án thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 3. Gán nhân viên vào dự án
    public void assignEmployeeToProject(int empId, int projId, String role) {
        try (Connection conn = getConnection()) {
            // Kiểm tra tồn tại
            String checkEmp = "SELECT id FROM Employee WHERE id = ?";
            String checkProj = "SELECT id FROM Project WHERE id = ?";
            PreparedStatement psE = conn.prepareStatement(checkEmp); psE.setInt(1, empId);
            PreparedStatement psP = conn.prepareStatement(checkProj); psP.setInt(1, projId);
            
            if (!psE.executeQuery().next() || !psP.executeQuery().next()) {
                System.out.println("=> Lỗi: ID nhân viên hoặc dự án không tồn tại!");
                return;
            }
            String sql = "INSERT INTO Assignment VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empId); ps.setInt(2, projId); ps.setString(3, role);
            ps.executeUpdate();
            System.out.println("=> Gán nhân viên vào dự án thành công.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4. Hiển thị danh sách nhân viên và dự án
    public void listEmployeesAndProjects() {
        String sql = "SELECT e.name as empName, p.name as projName, a.role " +
                     "FROM Employee e JOIN Assignment a ON e.id = a.employee_id " +
                     "JOIN Project p ON a.project_id = p.id";
        try (Connection conn = getConnection(); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            System.out.println("\n--- DANH SÁCH PHÂN CÔNG ---");
            while (rs.next()) {
                System.out.printf("Nhân viên: %s | Dự án: %s | Vai trò: %s\n",
                    rs.getString("empName"), rs.getString("projName"), rs.getString("role"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 5. Cập nhật lương nhân viên
    public void updateEmployeeSalary(int empId, double newSalary) {
        try (Connection conn = getConnection()) {
            String sql = "UPDATE Employee SET salary = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);
            if (ps.executeUpdate() > 0) System.out.println("=> Cập nhật lương thành công.");
            else System.out.println("=> Lỗi: Không tìm thấy nhân viên.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
