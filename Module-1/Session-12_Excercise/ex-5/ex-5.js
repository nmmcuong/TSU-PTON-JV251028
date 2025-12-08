console.log("----------Bài 1: In dãy fibonacci ----------");
let a = 0, b = 1, next;
console.log("Dãy Fibonacci:");
for (let i = 1; i <= 24; i++) {
    console.log(a);
    next = a + b;
    a = b;
    b = next;
}

console.log("----------Bài 2: Tính giai thừa của một số nguyên dương ----------");
let num = 5;
let factorial = 1;
for (let i = 1; i <= num; i++) {
    factorial *= i;
}
console.log(`Giai thừa của ${num} là: ${factorial}`);

console.log("----------Bài 3: In tam giác vuông. ----------");

let height = 5;
console.log("Tam giác vuông với góc vuông ở dưới bên trái:");
for (let i = 1; i <= height; i++) {
    console.log("*".repeat(i));
}
console.log("Tam giác vuông với góc vuông ở trên bên trái:");
for (let i = height; i >= 1; i--) {
    console.log("*".repeat(i));
}
console.log("Tam giác vuông với góc vuông ở dưới bên phải:");
for (let i = 1; i <= height; i++) {
    console.log(" ".repeat(height - i) + "*".repeat(i));
}
console.log("Tam giác vuông với góc vuông ở trên bên phải:");
for (let i = height; i >= 1; i--) {
    console.log(" ".repeat(height - i) + "*".repeat(i));
}

console.log("----------Bài 4: In hình chữ nhật rỗng ----------");
let rows = 7;
let cols = 21;
for (let i = 1; i <= rows; i++) {
    if (i === 1 || i === rows) {
        console.log("*".repeat(cols));
    } else {
        console.log("*" + " ".repeat(cols - 2) + "*");
    }
}

console.log("----------Bài 5: Viết chương trình tính lãi ngân hàng (lãi mẹ đẻ lãi con) khi biết số tiền ban đầu, số tháng cho vay và lãi suất hàng tháng. ----------");
let principal = 1000000;
let months = 12;
let monthlyRate = 0.05;
let amount = principal * Math.pow((1 + monthlyRate), months);
console.log(`Số tiền sau ${months} tháng là: ${amount.toFixed(2)} VND`);

