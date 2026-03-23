package Ex7;
public class Main {
    public static void main(String[] args) {
        try {
            // Tạo 2 phân số: 1/2 và 2/3
            Fraction f1 = new Fraction(1, 2);
            Fraction f2 = new Fraction(2, 3);

            System.out.println("Phân số 1: " + f1);
            System.out.println("Phân số 2: " + f2);
            System.out.println("-------------------------");

            // Thực hiện các phép toán
            System.out.println("Cộng: " + f1 + " + " + f2 + " = " + f1.add(f2));
            System.out.println("Trừ:  " + f1 + " - " + f2 + " = " + f1.subtract(f2));
            System.out.println("Nhân: " + f1 + " * " + f2 + " = " + f1.multiply(f2));
            System.out.println("Chia: " + f1 + " / " + f2 + " = " + f1.divide(f2));

            // Thử nghiệm rút gọn một phân số chưa tối giản
            Fraction f3 = new Fraction(10, 20);
            System.out.println("\nPhân số chưa rút gọn: 10/20");
            System.out.println("Sau khi rút gọn: " + f3.simplify());

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
