package Ex2;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Book
        Book myBook = new Book();

        // Thiết lập giá trị thông qua setter
        myBook.setTitle("Lập trình Java cơ bản");
        myBook.setAuthor("Nguyễn Văn A");
        myBook.setPrice(150000);

        // Truy cập và in thông tin thông qua getter     
        System.out.println("Tên sách: " + myBook.getTitle());
        System.out.println("Tác giả: " + myBook.getAuthor());
        System.out.println("Giá bán: " + myBook.getPrice() + " VNĐ");

        System.out.println("\n--- Thử nghiệm thay đổi giá ---");

        // Thử thay đổi giá trị hợp lệ
        myBook.setPrice(200000);
        System.out.println("Giá sau khi cập nhật (hợp lệ): " + myBook.getPrice());

        // Thử thay đổi giá trị không hợp lệ (số âm)
        System.out.print("Cố gắng cập nhật giá âm: ");
        myBook.setPrice(-50000); 
        System.out.println("Giá sau khi cập nhật (không hợp lệ): " + myBook.getPrice());
    }
}
