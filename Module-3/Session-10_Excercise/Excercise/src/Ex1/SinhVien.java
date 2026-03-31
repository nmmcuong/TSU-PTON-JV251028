package Ex1;

class SinhVien {
    private String ten;
    private int tuoi;
    private double diemTB;

    public SinhVien(String ten, int tuoi, double diemTB) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "Tên: " + ten + ", Tuổi: " + tuoi + ", Điểm trung bình: " + diemTB;
    }
}