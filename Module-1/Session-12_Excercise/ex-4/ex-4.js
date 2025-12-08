console.log("----------Bài 1: Đếm từ 1 đến 100 ----------");
for (let i = 1; i <= 100; i++) {
    if (i === 99){
        alert("Đã hoàn thành!");
    }
    else {
        continue;
    }
}

console.log("----------Bài 2: Lấy thông tin nhiệt độ từ người dùng ----------");
let temp = Number(prompt("Nhập nhiệt độ hiện tại (°C):"));
if (temp > 100) {
    console.log("Vui lòng giảm nhiệt độ");
} else if (temp < 20) {
    console.log("Vui lòng tăng nhiệt độ");
}

console.log("----------Bài 3: In ra 20 số trong dãy fibonacci ----------");
let n1 = 0, n2 = 1, nextTerm;
console.log("20 số đầu tiên trong dãy Fibonacci là:");
for (let i = 1; i <= 20; i++) {
    console.log(n1);
    nextTerm = n1 + n2;
    n1 = n2;
    n2 = nextTerm;
}

console.log("----------Bài 4: Tìm số đầu tiên trong dãy fibonacci chia hết cho 5 ----------");
let f1 = 0, f2 = 1, nextFibo;
while (true) {
    nextFibo = f1 + f2;
    if (nextFibo % 5 === 0) {
        console.log(`Số đầu tiên trong dãy Fibonacci chia hết cho 5 là: ${nextFibo}`);
        break;
    }
    f1 = f2;
    f2 = nextFibo;
}

console.log("----------Bài 5: Tính tổng của 20 số đầu tiên trong dãy fibonacci. ----------");
let fib1 = 0, fib2 = 1, nextFiboTerm;
let sum = fib1 + fib2;  
for (let i = 3; i <= 20; i++) {
    nextFiboTerm = fib1 + fib2;
    sum += nextFiboTerm; 
    fib1 = fib2;
    fib2 = nextFiboTerm;
}   
console.log(`Tổng của 20 số đầu tiên trong dãy Fibonacci là: ${sum}`);

console.log("----------Bài 6: Tính tổng của 30 số chia hết cho 7 đầu tiên trong các số tự nhiên. ----------");
let total = 0;
let count = 0;
let number = 1;
while (count < 30) {
    if (number % 7 === 0) {
        total += number;
        count++;
    }
    number++;
}
console.log(`Tổng của 30 số chia hết cho 7 đầu tiên trong các số tự nhiên là: ${total}`);

console.log("----------Bài 7: In từ 1 - 100   ----------");
for (let i = 1; i <= 100; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
        console.log("FizzBuzz");
    } else if (i % 3 === 0) {
        console.log("Fizz");
    } else if (i % 5 === 0) {
        console.log("Buzz");
    } else {
        console.log(i);
    }
}
