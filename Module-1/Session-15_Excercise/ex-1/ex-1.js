console.log("------ Bài 1 -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử. Chương trình thực hiện tính và hiển thị xem có bao nhiêu số nguyên lớn hơn hoặc bằng 10.
let arr = [];
for (let i = 0; i < 10; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr.push(num);
}
console.log("Mảng đã nhập: ", arr);
let count = 0;
for (let i = 0; i < arr.length; i++) {
    if (arr[i] >= 10) {
        count++;
    }
}
console.log(`Số lượng số nguyên lớn hơn hoặc bằng 10 là: ${count}`);

console.log("------ Bài 2: -------");
//Bài 2: Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử khác nhau. Chương trình hiển thị ra được phần tử có giá trị lớn nhất trong mảng và vị trí của phần tử đó.
let arr2 = [];
for (let i = 0; i < 10; i++) {
    let num;
    do {
        num = parseInt(prompt(`Nhập phần tử thứ ${i + 1} (khác nhau): `));
    } while (arr2.includes(num));
    arr2.push(num);
}
console.log("Mảng đã nhập: ", arr2);
let max = arr2[0];
let index = 0;
for (let i = 1; i < arr2.length; i++) {
    if (arr2[i] > max) {
        max = arr2[i];
        index = i;
    }
}
console.log(`Phần tử có giá trị lớn nhất là: ${max} tại vị trí index: ${index}`);

console.log("------ Bài 3:   -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên. Hiển hiện giá trị lớn nhất trong mảng đó và giá trị trung bình của các phần tử trong mảng.
let arr3 = [];
let n = parseInt(prompt("Nhập số lượng phần tử của mảng: "));
for (let i = 0; i < n; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr3.push(num);
}
console.log("Mảng đã nhập: ", arr3);
let max3 = arr3[0];
let sum = 0;
for (let i = 0; i < arr3.length; i++) {
    if (arr3[i] > max3) {
        max3 = arr3[i];
    }
    sum += arr3[i];
}
let avg = sum / arr3.length;
console.log(`Giá trị lớn nhất trong mảng là: ${max3}`);
console.log(`Giá trị trung bình của các phần tử trong mảng là: ${avg}`);

console.log("------ Bài 4:  -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên và đảo ngược các phần tử trong mảng đó.

let arr4 = [];
let m = parseInt(prompt("Nhập số lượng phần tử của mảng: "));
for (let i = 0; i < m; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr4.push(num);
}
console.log("Mảng đã nhập: ", arr4);
let reversedArr = [];
for (let i = arr4.length - 1; i >= 0; i--) {
    reversedArr.push(arr4[i]);
}
console.log("Mảng sau khi đảo ngược: ", reversedArr);

console.log("------ Bài 5: -------");
//Bài 5: Viết chương trình đếm số nguyên âm trong một chuỗi.
let str = prompt("Nhập một chuỗi gồm các số nguyên (cách nhau bởi dấu cách): ");
let strArr = str.split(" ");
let negativeCount = 0;
for (let i = 0; i < strArr.length; i++) {
    let num = parseInt(strArr[i]);
    if (num < 0) {
        negativeCount++;
    }
}
console.log(`Số lượng số nguyên âm trong chuỗi là: ${negativeCount}`);

console.log("------ Bài 6:  -------");
//Bài 6: Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử. Nhập phần tử số nguyên và tìm xem số đó có nằm trong mảng số nguyên không? Nếu có thuộc mảng số nguyên thì in ra "Number X is in the array" còn lại in ra "Number X is not in the array".
let arr6 = [];
for (let i = 0; i < 10; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr6.push(num);
}
let enter = parseInt(prompt(`Nhập số nguyên cần  tìm trong mảng: `));
for (let i = 0; i < arr6.length - 1; i++) {
    if (arr6[i] = enter) {
        console.log(`Number X is in the array`);
        break;
    } else {
        console.log(`Number X is not in the array`);
        break;
    }
}

console.log("------ Bài 7: -------");
//Viết chương trình khởi tạo nhập vào một mảng số nguyên gồm 10 phần tử. Chương trình sắp xếp mảng theo thứ tự giảm dần và hiển thị ra mảng đã được sắp xếp.

let arr7 = [];
for (let i = 0; i < 10; i++) {
    let num = parseInt(prompt(`Nhập phần tử thứ ${i + 1}: `));
    arr7.push(num);
}
console.log("Mảng đã nhập: ", arr7);
arr7.sort(function(a, b) {
    return b - a;
});
console.log("Mảng sau khi sắp xếp giảm dần: ", arr7);


console.log("------ Bài 8: -------");
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
console.log("Mảng a: ", a);
console.log("Mảng b: ", b);
console.log("Mảng c (nối từ a và b): ", c);

