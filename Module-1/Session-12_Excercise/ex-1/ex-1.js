let a = Number(prompt("Nhập số a:"));
let b = Number(prompt("Nhập số b:"));

console.log('----------Bài tập 1: ');
if (a % b === 0) {
    console.log(`${a} là bội số của ${b}`);
} else {
    console.log(`${a} không phải là bội số của ${b}`);
}

console.log('----------Bài tập 2: ');
let yearOld = Number(prompt("Nhập tuổi của học sinh:"));
if (yearOld < 16) {
    console.log("Học sinh này không đủ điều kiện vào lớp 10.");
} else {
    console.log("Học sinh này đủ điều kiện vào lớp 10.");
}

console.log('----------Bài tập 3: ');
let int = Number(prompt("Nhập một số nguyên:"));
if (int > 0) {
    console.log(`${int} là số lớn hơn 0.`);
}
else {
    console.log(`${int} không phải là số nhỏ hơn 0.`);
}

console.log('----------Bài tập 4: ');
let intA = Number(prompt("Nhập một số nguyên a:"));
let intB = Number(prompt("Nhập một số nguyên b:"));
let intC = Number(prompt("Nhập một số nguyên c:"));

let max = intA;
if (intB > max) {
    max = intB;
}
if (intC > max) {
    max = intC;
}
console.log(`Số lớn nhất trong 3 số là: ${max}`);

console.log('----------Bài tập 5: ');
let test = Number(prompt("Nhập điểm kiểm tra:"));
let midExam = Number(prompt("Nhập điểm giữa kỳ:"));
let finalExam = Number(prompt("Nhập điểm cuối kỳ:"));

let average = (test + midExam * 2 + finalExam * 3) / 6;
if (average >= 9) {
    console.log(`Điểm trung bình là: ${average.toFixed(2)} => Học sinh đạt loại Xuất sắc.`);
} else if (average >= 8) {
    console.log(`Điểm trung bình là: ${average.toFixed(2)} => Học sinh đạt loại Giỏi.`);
} else if (average >= 7) {
    console.log(`Điểm trung bình là: ${average.toFixed(2)} => Học sinh đạt loại Khá.`);
} else if (average >= 5) {
    console.log(`Điểm trung bình là: ${average.toFixed(2)} => Học sinh đạt loại Trung bình.`);
} else {
    console.log(`Điểm trung bình là: ${average.toFixed(2)} => Học sinh đạt loại Yếu.`);
}