package Ex10;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Nhập vào một số nguyên dương N (1-3999): ");
            int n = Integer.parseInt(sc.nextLine());
            
            if (n < 1 || n > 3999) {
                System.out.println("Vui lòng nhập số trong khoảng từ 1 đến 3999!");
            } else {
                String result = convertToRoman(n);
                System.out.println("Số La Mã tương ứng là: " + result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
        }
    }

    public static String convertToRoman(int num) {
        // Sử dụng LinkedHashMap để duy trì thứ tự từ lớn đến nhỏ
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder roman = new StringBuilder();
        
        // Duyệt qua Map từ giá trị lớn nhất đến nhỏ nhất
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            
            while (num >= value) {
                roman.append(symbol);
                num -= value;
            }
        }
        
        return roman.toString();
    }
}