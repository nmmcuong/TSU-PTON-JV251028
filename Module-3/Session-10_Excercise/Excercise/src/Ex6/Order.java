package Ex6;

class Order {
    private String maDH;
    private String tenKhachHang;

    public Order(String maDH, String tenKhachHang) {
        this.maDH = maDH;
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaDH() { return maDH; }
    public String getTenKhachHang() { return tenKhachHang; }

    @Override
    public String toString() {
        return "Mã đơn hàng: " + maDH + ", Tên khách hàng: " + tenKhachHang;
    }
}