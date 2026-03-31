package Ex4;

import java.util.ArrayList;

class AttendanceManager implements Manage<Student> {
    private ArrayList<Student> list = new ArrayList<>();

    @Override
    public void add(Student item) {
        list.add(item);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    @Override
    public void update(int id, Student newItem) {
        for (Student s : list) {
            if (s.getId() == id) {
                s.setName(newItem.getName());
                System.out.println("Sinh viên đã được sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID này.");
    }

    @Override
    public void delete(int id) {
        boolean removed = list.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Đã xóa thành công sinh viên !");
        } else {
            System.out.println("Không tìm thấy sinh viên có ID này.");
        }
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            for (Student s : list) {
                System.out.println(s);
            }
        }
    }
}