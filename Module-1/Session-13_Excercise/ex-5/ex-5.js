console.log("----------Bài 5: ----------");

let arr = [];
let length = Math.floor(Math.random() * 11) + 10; 
while (arr.length < length) {
    let randomNum = Math.floor(Math.random() * 100);
    arr.push(randomNum);
}
console.log("Mảng đã tạo:");
console.log(arr);
let sumOdd = 0;
let sumEven = 0;
for (let i = 0; i < arr.length; i++) {
    if (arr[i] % 2 === 0) {
        sumEven += arr[i];
    } else {
        sumOdd += arr[i];
    }
}
alert(`Tổng các số lẻ trong mảng là: ${sumOdd}`);
alert(`Tổng các số chẵn trong mảng là: ${sumEven}`);




