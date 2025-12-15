// Hàm tính tổng các phần tử trong mảng sử dụng reduce()
function sumArr(arr) {
    return arr.reduce((accumulator, currentValue) => {
        return accumulator + currentValue;
    }, 0);
}


// Các mảng ví dụ
const arr1 = [1, 2, 3, 4, 5, 6];
const arr2 = [10, 20, 30, 40, 50];
const arr3 = [1, 3, 5, 7, 9];


// Thực thi hàm và hiển thị kết quả
console.log(`Mảng arr1: [${arr1.join(', ')}]`);
console.log(`Tổng của arr1 là: ${sumArr(arr1)}`); // Kết quả: 21

console.log('---------------------------');

console.log(`Mảng arr2: [${arr2.join(', ')}]`);
console.log(`Tổng của arr2 là: ${sumArr(arr2)}`); // Kết quả: 150

console.log('---------------------------');

console.log(`Mảng arr3: [${arr3.join(', ')}]`);
console.log(`Tổng của arr3 là: ${sumArr(arr3)}`); // Kết quả: 25