package Ex1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class QuanLyHoaDon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Định dạng số để hiển thị tiền tệ có dấu phẩy
        DecimalFormat df = new DecimalFormat("#,###.00");

        // --- NHẬP THÔNG TIN ---
        System.out.println("========= NHẬP THÔNG TIN HÓA ĐƠN =========");
        System.out.print("Nhập tên khách hàng: ");
        String tenKhachHang = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double giaSanPham = sc.nextDouble();

        System.out.print("Nhập số lượng mua: ");
        int soLuong = sc.nextInt();

        System.out.print("Khách có thẻ thành viên? (true/false): ");
        boolean laThanhVien = sc.nextBoolean();

        // --- TÍNH TOÁN ---
        double thanhTien = giaSanPham * soLuong;
        
        // Giảm giá 10% nếu là thành viên
        double giamGia = 0;
        if (laThanhVien) {
            giamGia = thanhTien * 0.1;
        }

        // Tính VAT 8% (thường tính trên số tiền sau khi giảm hoặc tùy quy định, 
        // ở đây tính theo công thức: (Thành tiền - Giảm giá) * 8% để khớp logic hóa đơn thông thường)
        double tienVat = (thanhTien - giamGia) * 0.08;

        double tongThanhToan = thanhTien - giamGia + tienVat;

        // --- IN HÓA ĐƠN ---
        System.out.println("\n============== HÓA ĐƠN ==============");
        System.out.println("Khách hàng: " + tenKhachHang);
        System.out.println("Sản phẩm  : " + tenSanPham);
        System.out.println("Số lượng  : " + soLuong);
        System.out.println("Đơn giá   : " + df.format(giaSanPham) + " VND");
        System.out.println("Thành tiền: " + df.format(thanhTien) + " VND");
        System.out.println("Giảm giá thành viên (10%): " + df.format(giamGia) + " VND");
        System.out.println("Tiền VAT (8%): " + df.format(tienVat) + " VND");
        System.out.println("Tổng thanh toán: " + df.format(tongThanhToan) + " VND");
        System.out.println("======================================");
        
        sc.close();
    }
}