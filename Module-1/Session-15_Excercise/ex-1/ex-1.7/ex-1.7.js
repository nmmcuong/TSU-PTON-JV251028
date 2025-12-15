

alert("------ Bài 7: -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử. Chương trình sắp xếp mảng theo thứ tự giảm dần và hiển thị ra mảng đã được sắp xếp.

let arr7 = [];
for (let i = 0; i < 10; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr7.push(num);
}
alert("Mảng đã nhập: ", arr7);
arr7.sort(function(a, b) {
    return b - a;
});
alert("Mảng sau khi sắp xếp giảm dần: ", arr7);

