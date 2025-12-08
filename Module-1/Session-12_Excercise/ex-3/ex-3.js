console.log("----------Bài 3: In ra 20 số nguyên tố đầu tiên ----------");
let count = 0;


for (let i = 2; i <= count; i++) {
    if (i % 1 === 0 && i % i === 0 && count < 20) {
        console.log(`Số nguyên tố thứ ${count + 1} là: ${i}`);
        count++;
    }
    else if (count === 20) {
        break;
    }
    else {
        continue;
    }
}

