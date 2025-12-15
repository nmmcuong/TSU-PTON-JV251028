
alert("------ Bài 2: -------");
//Bài 2: Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử khác nhau. Chương trình hiển thị ra được phần tử có giá trị lớn nhất trong mảng và vị trí của phần tử đó.
let arr2 = [];
for (let i = 0; i < 10; i++) {
    let num;
    do {
        num = parseInt(prompt(`Nhập phần tử thứ ${i + 1} (khác nhau): `));
    } while (arr2.includes(num));
    arr2.push(num);
}
alert("Mảng đã nhập: ", arr2);
let max = arr2[0];
let index = 0;
for (let i = 1; i < arr2.length; i++) {
    if (arr2[i] > max) {
        max = arr2[i];
        index = i;
    }
}
alert(`Phần tử có giá trị lớn nhất là: ${max} tại vị trí index: ${index}`);
