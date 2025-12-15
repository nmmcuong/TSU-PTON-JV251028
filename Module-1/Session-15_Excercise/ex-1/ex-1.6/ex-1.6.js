

alert("------ Bài 6:  -------");
//Bài 6: Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử. Nhập phần tử số nguyên và tìm xem số đó có nằm trong mảng số nguyên không? Nếu có thuộc mảng số nguyên thì in ra "Number X is in the array" còn lại in ra "Number X is not in the array".
let arr6 = [];
for (let i = 0; i < 10; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr6.push(num);
}
let enter = parseInt(prompt(`Nhập số nguyên cần  tìm trong mảng: `));
for (let i = 0; i < arr6.length - 1; i++) {
    if (arr6[i] = enter) {
        alert(`Number X is in the array`);
        break;
    } else {
        alert(`Number X is not in the array`);
        break;
    }
}
