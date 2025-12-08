console.log("----------Bài 6  ----------");
let arr = [];
let length = Math.floor(Math.random() * 11) + 10;
while (arr.length < length) {
    let randomNum = Math.floor(Math.random() * 100);
    arr.push(randomNum);
}
console.log("Mảng đã tạo:");
console.log(arr);
let userInput = Number(prompt("Vui lòng nhập một số nguyên để kiểm tra:"));
let count = 0;
for (let i = 0; i < arr.length; i++) {
    if (arr[i] === userInput) {
        count++;
    }
}
if (count > 0) {
    alert(`Số ${userInput} xuất hiện ${count} lần trong mảng.`);
} else {
    alert(`Số ${userInput} không xuất hiện trong mảng.`);
}






