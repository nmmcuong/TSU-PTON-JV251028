console.log("----------Bài 3: ----------");
let userInput = prompt("Nhập vào dãy số, các số cách nhau bởi dấu phẩy (ví dụ: 1,2,3,4):");
let numArray = userInput.split(',').map(Number);
numArray.reverse();
console.log("Dãy số sau khi đảo ngược:");
console.log(numArray);




