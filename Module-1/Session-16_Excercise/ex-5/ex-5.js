//Cho người dùng nhập vào chuỗi ký tự và viết hàm kiểm tra xem đó có phải chuỗi ký tự đối xứng không:
function isPalindrome(str) {
    const len = str.length;
    for (let i = 0; i < len / 2; i++) {
        if (str[i] !== str[len - 1 - i]) {
            return false;
        }
    }
    return true;
}
let inputString = prompt('Nhập vào chuỗi ký tự cần kiểm tra: ');
let result = isPalindrome(inputString);
alert(`Kết quả là ${result}`);