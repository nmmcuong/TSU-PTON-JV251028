console.log("----------Bài 1:  ----------");
let arr = [];
while (arr.length < 10) {
    let randomNum = Math.floor(Math.random() * 100);
    arr.push(randomNum);
}
console.log("Mảng sau khi thêm đủ 10 phần tử:");
console.log(arr);
