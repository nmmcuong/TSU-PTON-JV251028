USE QLThuVien;
--
-- 1. Tạo bảng Độc giả (Reader)
CREATE TABLE reader (
    idReader INT PRIMARY KEY AUTO_INCREMENT,
    ReaderName VARCHAR(100) NOT NULL,
    Gender TINYINT COMMENT '0: Nữ, 1: Nam, 2: Khác',
    birthDay DATE
);

-- 2. Tạo bảng Sách (Books)
CREATE TABLE books (
    idBook INT PRIMARY KEY AUTO_INCREMENT,
    bookName VARCHAR(255) NOT NULL,
    author VARCHAR(100),
    type VARCHAR(50)
);

-- 3. Tạo bảng Mượn sách (Borrowings) 
CREATE TABLE borrowings (
    idborrowings INT PRIMARY KEY AUTO_INCREMENT,
    idReader INT NOT NULL, 
    idBook INT NOT NULL,   
    ngayMuon DATE NOT NULL,
    ngayTra DATE,
    CONSTRAINT FK_Reader_Borrowing FOREIGN KEY (idReader) 
        REFERENCES reader(idReader) ON DELETE CASCADE,
    CONSTRAINT FK_Book_Borrowing FOREIGN KEY (idBook) 
        REFERENCES books(idBook) ON DELETE CASCADE
) ;
