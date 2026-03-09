public class PhepToanCoBan {
    public static void main(String[] args) {
        // 1. Khai báo 2 biến kiểu số nguyên int và gán giá trị bất kỳ
        int a = 10;
        int b = 5;

        // 2. Thực hiện các phép toán
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        int thuong = a / b;
        int du = a % b;

        // 3. In giá trị 2 biến và kết quả ra màn hình theo định dạng
        System.out.printf("a = %d và b = %d\n", a, b);
        System.out.println("Tổng 2 số a+b = " + tong);
        System.out.println("Hiệu 2 số a-b = " + hieu);
        System.out.println("Tích 2 số a*b = " + tich);
        System.out.println("Thương 2 số a/b = " + thuong);
        System.out.println("Số dư khi chia số a cho b = " + du);
    }
}