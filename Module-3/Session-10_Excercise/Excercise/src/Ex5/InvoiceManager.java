package Ex5;

import java.util.ArrayList;

class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> list = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        list.add(item);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    @Override
    public void update(int id, Invoice newItem) {
        if (id > 0 && id <= list.size()) {
            list.set(id - 1, newItem);
            System.out.println("Hóa đơn đã được sửa thành công.");
        } else {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
        }
    }

    @Override
    public void delete(int id) {
        if (id > 0 && id <= list.size()) {
            list.remove(id - 1);
            System.out.println("Hóa đơn đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
        }
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". ID : " + (i + 1) + " , " + list.get(i));
            }
        }
    }
}