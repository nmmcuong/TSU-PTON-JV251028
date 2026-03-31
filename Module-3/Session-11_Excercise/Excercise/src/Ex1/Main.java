package Ex1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo một danh sách số nguyên
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 2. Sử dụng Lambda Expression để in ra tất cả các số chẵn
        System.out.println("Các số chẵn trong danh sách:");
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        // 3. Sử dụng Lambda Expression để tính tổng của tất cả các số
        // Cách 1: Sử dụng reduce
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        
        // Cách 2: Sử dụng mapToInt (ngắn gọn hơn)
        // int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Tổng của tất cả các số trong danh sách: " + sum);
    }
}
