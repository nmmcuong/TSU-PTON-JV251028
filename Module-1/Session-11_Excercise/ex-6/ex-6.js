let a = Number(prompt("Nhập số a:"));
let b = Number(prompt("Nhập số b:"));
let operation = prompt("Nhập phép toán (+, -, *, /):");

alert(`Kết quả của phép tính: ${a}  ${operation}  ${b} = ${
  operation === "+"
    ? a + b 
    : operation === "-"
    ? a - b
    : operation === "*"
    ? a * b
    : operation === "/"
    ? b !== 0
      ? a / b
      : "Lỗi: Không thể chia cho 0"
    : "Phép toán không hợp lệ"
}`);