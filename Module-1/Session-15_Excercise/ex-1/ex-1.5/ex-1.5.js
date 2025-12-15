

alert("------ Bài 5: -------");
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
alert(`Số lượng số nguyên âm trong chuỗi là: ${negativeCount}`);
