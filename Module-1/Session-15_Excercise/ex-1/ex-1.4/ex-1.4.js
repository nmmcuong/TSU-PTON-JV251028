

alert("------ Bài 4:  -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên và đảo ngược các phần tử trong mảng đó.

let arr4 = [];
let m = parseInt(prompt("Nhập số lượng phần tử của mảng: "));
for (let i = 0; i < m; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr4.push(num);
}
alert("Mảng đã nhập: ", arr4);
let reversedArr = [];
for (let i = arr4.length - 1; i >= 0; i--) {
    reversedArr.push(arr4[i]);
}
alert("Mảng sau khi đảo ngược: ", reversedArr);
