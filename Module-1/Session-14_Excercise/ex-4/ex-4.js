console.log("----------Bài 4: Tạo một đối tượng original ----------");
let original = {
    name: "Bob",
    age: 30,
};
//Tạo một bản sao của đối tượng original và gán vào biến copy
let copy = { ...original };
//Thay đổi thuộc tính name của đối tượng copy thành "Charlie"
copy.name = "Charlie";
console.log("Đối tượng original:");
console.log(original);
console.log("Đối tượng copy sau khi thay đổi thuộc tính name:");
console.log(copy);

