
alert("------ Bài 3:   -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên. Hiển hiện giá trị lớn nhất trong mảng đó và giá trị trung bình của các phần tử trong mảng.
let arr3 = [];
let n = parseInt(prompt("Nhập số lượng phần tử của mảng: "));
for (let i = 0; i < n; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr3.push(num);
}
alert("Mảng đã nhập: ", arr3);
let max3 = arr3[0];
let sum = 0;
for (let i = 0; i < arr3.length; i++) {
    if (arr3[i] > max3) {
        max3 = arr3[i];
    }
    sum += arr3[i];
}
let avg = sum / arr3.length;
alert(`Giá trị lớn nhất trong mảng là: ${max3}`);
alert(`Giá trị trung bình của các phần tử trong mảng là: ${avg}`);
