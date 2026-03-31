package Ex6;

import java.util.ArrayList;

class OrderManager implements Manage<Order> {
    private ArrayList<Order> list = new ArrayList<>();

    @Override
    public void add(Order item) {
        list.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    @Override
    public void update(String maDH, Order newItem) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaDH().equalsIgnoreCase(maDH)) {
                list.set(i, newItem);
                System.out.println("Đơn hàng đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy mã đơn hàng: " + maDH);
    }

    @Override
    public void delete(String maDH) {
        boolean removed = list.removeIf(o -> o.getMaDH().equalsIgnoreCase(maDH));
        if (removed) {
            System.out.println("Đơn hàng đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy đơn hàng cần xóa.");
        }
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}