
alert("------ Bài 8: -------");
//Bài 8: Viết chương trình khởi tạo nhập vào 2 mảng số nguyên gồm 10 phần tử, gọi là mảng a và b. Mảng c là một mảng được khai báo gồm 20 phần tử số nguyên. Chương trình sẽ lưu các phần tử được nối từ hai mảng b và a vào mảng c. Hiển thị mảng c.
let a = [];
let b = [];
for (let i = 0; i < 10; i++) {
    let numA = parseInt(prompt(`Nhập phần tử thứ ${i + 1} của mảng a: `));
    a.push(numA);
}
for (let i = 0; i < 10; i++) {
    let numB = parseInt(prompt(`Nhập phần tử thứ ${i + 1} của mảng b: `));
    b.push(numB);
}
let c = a.concat(b);
alert("Mảng a: ", a);
alert("Mảng b: ", b);
alert("Mảng c (nối từ a và b): ", c);

