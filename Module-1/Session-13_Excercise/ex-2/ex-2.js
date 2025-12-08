console.log("----------Bài 2: ----------");
let numberArray = [10, 23, 45, 70, 11, 3, 99, 27, 56, 78];
let userInput = Number(prompt("Vui lòng nhập một số bất kỳ:"));
if (numberArray.includes(userInput)) {
    //console.log(`Số ${userInput} có trong mảng.`);
    alert(`Số ${userInput} có trong mảng. Bingo!!!`);
} else {
    alert(`Số ${userInput} không có trong mảng. Chúc bạn may mắn lần sau`);
}


