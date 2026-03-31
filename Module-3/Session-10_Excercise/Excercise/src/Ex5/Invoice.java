package Ex5;

class Invoice {
    private String maHD;
    private double soTien;

    public Invoice(String maHD, double soTien) {
        this.maHD = maHD;
        this.soTien = soTien;
    }

    public String getMaHD() { return maHD; }
    public double getSoTien() { return soTien; }

    @Override
    public String toString() {
        return "Mã hóa đơn: " + maHD + ", Số tiền: " + soTien;
    }
}