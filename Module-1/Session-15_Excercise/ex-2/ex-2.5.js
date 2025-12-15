
console.log("------ Bài 5: -------");
//Viết chương trình nhập vào một mảng ký tự, tìm tất cả các ký tự trong mảng là (-) và thay thế các ký tự này bởi ký tự ( _ )

let arr = [];
let n = parseInt(prompt("Nhập số lượng ký tự trong mảng:"));
for (let i = 0; i < n; i++) {
    let char = prompt(`Nhập ký tự thứ ${i + 1}:`);
    arr.push(char);
}
console.log("Mảng ban đầu: ", arr);

for (let i = 0; i < arr.length; i++) {
    if (arr[i] === '-') {
        arr[i] = '_';
    }
}
console.log("Mảng sau khi thay thế: ", arr);



