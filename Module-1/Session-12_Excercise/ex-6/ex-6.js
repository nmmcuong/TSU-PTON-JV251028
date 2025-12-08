console.log("---------- Tạo menu 10 lựa chọn, Lựa chọn 10 thoát ----------");
let choice;
let userName = ""; // Biến lưu tên người dùng
let userAge = 0;   // Biến lưu tuổi người dùng
let isRunning = true; // Biến kiểm soát vòng lặp chính

// Vòng lặp chính của chương trình
do {
    // 1. Hiển thị Menu và nhận lựa chọn từ người dùng
    choice = Number(prompt(`Menu Chương Trình:
1. Nhập tên của người dùng.
2. Nhập tuổi của người dùng.
3. In tên và tuổi của người dùng.
4. In bảng cửu chương của một số.
5. Kiểm tra số nhập vào là số chẵn hay lẻ.
6. Tính tổng các số từ 1 đến N (N do người dùng nhập).
7. In các số trong một dãy (người dùng nhập dãy số).
8. Kiểm tra số nhập vào có phải là số nguyên tố hay không.
9. In chuỗi đảo ngược của một chuỗi mà người dùng nhập.
10. Thoát khỏi chương trình.
---------------------------------------
Vui lòng nhập lựa chọn của bạn (1-10):`));

    // 2. Xử lý lựa chọn bằng switch case
    switch (choice) {
        case 1:
            // Lựa chọn 1: Nhập tên
            userName = prompt("Vui lòng nhập tên của bạn:");
            alert(`Đã lưu tên: ${userName}`);
            break;
        case 2:
            // Lựa chọn 2: Nhập tuổi
            userAge = Number(prompt("Vui lòng nhập tuổi của bạn:"));
            alert(`Đã lưu tuổi: ${userAge}`);
            break;
        case 3:
            // Lựa chọn 3: In tên và tuổi
            if (userName && userAge > 0) {
                alert(`Thông tin người dùng:\nTên: ${userName}\nTuổi: ${userAge}`);
            } else {
                alert("Vui lòng nhập tên (1) và tuổi (2) trước khi in.");
            }
            break;
        case 4:
            // Lựa chọn 4: In bảng cửu chương
            let num = Number(prompt("Nhập số bạn muốn in bảng cửu chương:"));
            let table = `Bảng cửu chương của ${num}:\n`;
            for (let i = 1; i <= 10; i++) {
                table += `${num} x ${i} = ${num * i}\n`;
            }
            alert(table);
            break;
        case 5:
            // Lựa chọn 5: Kiểm tra chẵn/lẻ
            let checkNum = Number(prompt("Nhập số cần kiểm tra chẵn/lẻ:"));
            if (checkNum % 2 === 0) {
                alert(`${checkNum} là số chẵn.`);
            } else {
                alert(`${checkNum} là số lẻ.`);
            }
            break;
        case 6:
            // Lựa chọn 6: Tính tổng từ 1 đến N
            let N = Number(prompt("Nhập N (số cuối cùng) để tính tổng từ 1 đến N:"));
            let sum = 0;
            for (let i = 1; i <= N; i++) {
                sum += i;
            }
            alert(`Tổng các số từ 1 đến ${N} là: ${sum}`);
            break;
        case 7:
            // Lựa chọn 7: In các số trong một dãy
            let sequence = prompt("Nhập một dãy số, cách nhau bằng dấu phẩy:");
        let numbers = sequence.split(',').map(Number);
        console.log("Các số trong dãy là:");
        numbers.forEach(num => console.log(num));
            break;
        case 8:
            // Lựa chọn 8: Kiểm tra số nguyên tố
            let pNum = Number(prompt("Nhập số để kiểm tra nguyên tố:"));
            let isPrime = true;
            if (pNum <= 1) {
                isPrime = false;
            } else {
                for (let i = 2; i <= Math.sqrt(pNum); i++) {
                    if (pNum % i === 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            alert(isPrime ? `${pNum} là số nguyên tố.` : `${pNum} không phải là số nguyên tố.`);
            break;
        case 9:
            // Lựa chọn 9: In chuỗi đảo ngược
            let originalStr = prompt("Nhập một chuỗi:");
            let reversedStr = originalStr.split('').reverse().join('');
            alert(`Chuỗi đảo ngược là: ${reversedStr}`);
            break;
        case 10:
            // Lựa chọn 10: Thoát
            alert("Thoát khỏi chương trình. Tạm biệt!");
            isRunning = false; // Đặt biến điều kiện thoát thành false
            break;
        default:
            // Xử lý các lựa chọn không hợp lệ
            alert("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 10.");
    }

    // Tạm dừng để người dùng xem kết quả alert trước khi menu hiển thị lại
    if (isRunning) {
        // Có thể thêm đoạn code tạm dừng nếu cần, nhưng alert đã giúp dừng tạm thời.
    }

} while (isRunning);

console.log("Chương trình đã kết thúc.");

