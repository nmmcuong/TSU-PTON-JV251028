console.log("----------Bài 4:  ----------");

let userInput = prompt("Nhập vào dãy số, các số cách nhau bởi dấu phẩy (ví dụ: 1,2,3,4):");
let numArray = userInput.split(',').map(Number);
let max = numArray[0];
for (let i = 1; i < numArray.length; i++) {
    if (numArray[i] > max) {
        max = numArray[i];
    }
}
alert(`Phần tử có giá trị lớn nhất trong mảng là: ${max}`);




