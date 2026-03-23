package Ex7;
public class Fraction {
    private int numerator;   // Tử số
    private int denominator; // Mẫu số

    // Constructor
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Getter và Setter
    public int getNumerator() { return numerator; }
    public void setNumerator(int numerator) { this.numerator = numerator; }

    public int getDenominator() { return denominator; }
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
        }
        this.denominator = denominator;
    }

    // Tìm ước chung lớn nhất (GCD) để rút gọn
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Phương thức rút gọn phân số
    public Fraction simplify() {
        int common = gcd(numerator, denominator);
        this.numerator /= common;
        this.denominator /= common;
        
        // Đảm bảo dấu trừ nằm ở tử số nếu phân số âm
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        return this;
    }

    // Phép cộng
    public Fraction add(Fraction other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den).simplify();
    }

    // Phép trừ
    public Fraction subtract(Fraction other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den).simplify();
    }

    // Phép nhân
    public Fraction multiply(Fraction other) {
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den).simplify();
    }

    // Phép chia
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Không thể chia cho phân số có tử số bằng 0.");
        }
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        return new Fraction(num, den).simplify();
    }

    @Override
    public String toString() {
        if (denominator == 1) return String.valueOf(numerator);
        return numerator + "/" + denominator;
    }
}
