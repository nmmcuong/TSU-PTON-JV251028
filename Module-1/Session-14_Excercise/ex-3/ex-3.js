
console.log("----------Bài 5: Tạo một đối tượng book ----------");
let book = {
    title: "JavaScript Basics",
    author: "Jane Doe",
    page: 200
};
//xóa thuộc tính page khỏi đối tượng book
delete book.page;
console.log("Đối tượng book sau khi xóa thuộc tính page:");
console.log(book);
