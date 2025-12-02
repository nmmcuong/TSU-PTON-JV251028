let year = Number(prompt("Enter a year:"));
if ((year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0) && year % 100 === 0) {
    alert(`${year} là năm nhuận`);
}
else if ((year % 400 !== 0) && year % 100 === 0) {
    alert(`${year} không phải năm nhuận`);
}