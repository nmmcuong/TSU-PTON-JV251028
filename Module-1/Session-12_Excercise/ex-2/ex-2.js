console.log("----------Bài 1: Chuyển đổi độ C sang độ F ----------");
let doC = Number(prompt("Nhập nhiệt độ (°C):"));
const toF = (doC * 9/5) + 32;
console.log(`${doC}°C = ${toF.toFixed(2)}°F`);

console.log("----------Bài 2: Chuyển từ mét sang feet ----------");
let met = Number(prompt("Nhập chiều dài (mét):"));
const toFeet = met * 3.28084;
console.log(`${met} mét = ${toFeet.toFixed(2)} feet`);

console.log("----------Bài 3: Tính diện tích hình vuông khi biết cạnh a ----------");
let canhA = Number(prompt("Nhập độ dài cạnh a (mét):"));
const dienTichHinhVuong = canhA * canhA;
console.log(`Diện tích hình vuông có cạnh a = ${canhA} mét là: ${dienTichHinhVuong.toFixed(2)} mét vuông`);

console.log("----------Bài 4: Tính diện tích chữ nhật biết 2 cạnh a, b ----------");
let cnA = Number(prompt("Nhập độ dài cạnh a (mét):"));
let cnB = Number(prompt("Nhập độ dài cạnh b (mét):"));
const dienTichHinhChuNhat = cnA * cnB;
console.log(`Diện tích hình chữ nhật có cạnh a = ${cnA} mét và b = ${cnB} mét là: ${dienTichHinhChuNhat.toFixed(2)} mét vuông`);

console.log("----------Bài 5: Tính diện tích tam giác vuông khi biết 2 cạnh kề a,b ----------");
let tgA = Number(prompt("Nhập độ dài cạnh a (mét):"));
let tgB = Number(prompt("Nhập độ dài cạnh b (mét):"));
const dienTichTamGiacVuong = (tgA * tgB) / 2;
console.log(`Diện tích tam giác vuông có cạnh a = ${tgA} mét và b = ${tgB} mét là: ${dienTichTamGiacVuong.toFixed(2)} mét vuông`);

console.log("----------Bài 6: Giải phuonge trình bậc 1 ----------");
let soA = Number(prompt("Nhập hệ số a:"));
let soB = Number(prompt("Nhập hệ số b:"));

if (soA === 0) {
    if (soB === 0) {
        console.log("Phương trình vô số nghiệm.");
    } else {
        console.log("Phương trình vô nghiệm.");
    }
} else {
    let nghiem = -soB / soA;
    console.log(`Phương trình có nghiệm là: x = ${nghiem.toFixed(2)}`);
}

console.log("----------Bài 7: Giải phuonge trình bậc 2 ----------");
let a2 = Number(prompt("Nhập hệ số a:"));
let b2 = Number(prompt("Nhập hệ số b:"));
let c2 = Number(prompt("Nhập hệ số c:"));
const delta = b2 * b2 - 4 * a2 * c2;
if (a2 === 0) {
    if (b2 === 0) {
        if (c2 === 0) { 
            console.log("Phương trình vô số nghiệm.");
        } else {
            console.log("Phương trình vô nghiệm.");
        }
    } else {
        let nghiem = -c2 / b2;
        console.log(`Phương trình có nghiệm là: x = ${nghiem.toFixed(2)}`);
    }
} else {
    if (delta < 0) {
        console.log("Phương trình vô nghiệm.");
    } else if (delta === 0) {
        let nghiemKep = -b2 / (2 * a2);
        console.log(`Phương trình có nghiệm kép: x1 = x2 = ${nghiemKep.toFixed(2)}`);
    }
    else {
        let nghiem1 = (-b2 + Math.sqrt(delta)) / (2 * a2);
        let nghiem2 = (-b2 - Math.sqrt(delta)) / (2 * a2);
        console.log(`Phương trình có hai nghiệm phân biệt: x1 = ${nghiem1.toFixed(2)}, x2 = ${nghiem2.toFixed(2)}`);
    }
}

console.log("----------Bài 8: Kiểm tra số nhập vào có phải là tuổi của một người hay không ----------");
let ageInput = prompt("Nhập tuổi của bạn:");

if (ageInput > 0 && ageInput < 120) {
    console.log(`${ageInput} là tuổi của nột người là: ${ageInput}`);
} else {
    console.log(`${ageInput} không hợp lệ. Vui lòng nhập một số từ 1 đến 119.`);
}