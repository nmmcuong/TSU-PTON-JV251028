create database HotelManager;
use HotelManager;
create table Customer(
customer_id VARCHAR(5) not null primary key,
customer_full_name VARCHAR(100) not null,
customer_email VARCHAR(100) UNIQUE not null,
customer_phone VARCHAR(15) not null,
customer_address VARCHAR(255) not null
);

create table Room(
room_id varchar(5) not null primary key,
room_type VARCHAR(50) not null,
room_price DECIMAL(10, 2) not null,
room_status VARCHAR(20) not null,
room_area INT not null
);

create table Booking (
booking_id int not null primary key auto_increment,
customer_id VARCHAR(5) not null,
room_id VARCHAR(5) not null,
check_in_date DATE not null,
check_out_date DATE not null,
total_amount DECIMAL(10, 2),
foreign key (customer_id) references Customer(customer_id),
foreign key (room_id) references Room(room_id)
);

create table Payment(
 payment_id int primary key not null auto_increment,
 booking_id int not null,
 payment_method VARCHAR(50) not null,
 payment_date DATE not null,
 payment_amount DECIMAL(10, 2) not null,
 foreign key (booking_id) references Booking(booking_id)
);


#Insert data
insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address) 
value ('C001','Nguyen Anh Tu', 'tu.nguyen@example.com', '0912345678', 'Hanoi, Vietnam');
insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C002', 'Tran Thi Mai', 'mai.tran@example.com', '0923456789', 'Ho Chi Minh, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C003', 'Le Minh Hoang', 'hoang.le@example.com', '0934567890', 'Danang, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C004', 'Pham Hoang Nam', 'nam.pham@example.com', '0945678901', 'Hue, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C005', 'Vu Minh Thu', 'thu.vu@example.com', '0956789012', 'Hai Phong, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C006', 'Nguyen Thi Lan', 'lan.nguyen@example.com', '0967890123', 'Quang Ninh, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C007', 'Bui Minh Tuan', 'tuan.bui@example.com', '0978901234', 'Bac Giang, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C008', 'Pham Quang Hieu', 'hieu.pham@example.com', '0989012345', 'Quang Nam, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C009', 'Le Thi Lan', 'lan.le@example.com', '0990123456', 'Da Lat, Vietnam');
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address)
 value ('C010', 'Nguyen Thi Mai', 'mai.nguyen@example.com', '0901234567', 'Can Tho, Vietnam');
 
 
 insert into Room(room_id,room_type,room_price,room_status,room_area)
 value ('R001', 'Single', '100', 'Available', '25');
 insert into Room(room_id,room_type,room_price,room_status,room_area)
 value ('R002', 'Double', '150', 'Booked', '40');
 insert into Room(room_id,room_type,room_price,room_status,room_area)
 value ('R003', 'Suite', '250', 'Available', '60');
 insert into Room(room_id,room_type,room_price,room_status,room_area)
 value ('R004', 'Single', '120', 'Booked', '30');
 insert into Room(room_id,room_type,room_price,room_status,room_area)
 value ('R005', 'Double', '160', 'Available', '35');


 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C001', 'R001', '2025-03-01', '2025-03-05', 400.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C002', 'R002', '2025-03-02', '2025-03-06', 600.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C003', 'R003', '2025-03-03', '2025-03-07', 1000.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C004', 'R004', '2025-03-04', '2025-03-08', 480.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C005', 'R005', '2025-03-05', '2025-03-09', 800.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C006', 'R001', '2025-03-06', '2025-03-10', 400.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C007', 'R002', '2025-03-07', '2025-03-11', 600.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C008', 'R003', '2025-03-08', '2025-03-12', 1000.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C009', 'R004', '2025-03-09', '2025-03-13', 480.0);
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C010', 'R005', '2025-03-10', '2025-03-14', 800.0);
 
 select * from booking;
select * from Payment;
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (1, 'Cash', '2025-03-05', 400.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (2, 'Credit Card', '2025-03-06', 600.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (3,'Bank Transfer','2025-03-07',1000.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (4, 'Cash', '2025-03-08',480.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (5, 'Credit Card','2025-03-09',800.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (6, 'Bank Transfer','2025-03-10',400.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (7, 'Cash','2025-03-11',600.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (8, 'Credit Card','2025-03-12',1000.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (9, 'Bank Transfer','2025-03-13',480.0);
insert into Payment(booking_id,payment_method,payment_date,payment_amount)value (10, 'Cash','2025-03-14' ,800.0);

#3
update Booking b
join Room r on b.room_id = r.room_id
SET b.total_amount = r.room_price * DATEDIFF(b.check_out_date, b.check_in_date)
where
r.room_status = 'Booked'
and b.check_in_date < CURDATE();

#4
delete from Payment
where payment_method = 'Cash' 
and payment_amount < 500;

select * from Payment;

#PHẦN 2: Truy vấn dữ liệu
#5. 
select * from Customer order by  customer_full_name ASC;

#6
select room_id, room_type, room_price, room_area 
from Room
order by room_price DESC;

#7
select c.customer_id, c.customer_full_name, r.room_id, b.check_in_date, b.check_out_date
from Booking b
join Customer c on b.Customer_id = c.customer_id
join Room r on b.room_id = r.room_id;

#8
select c.customer_id,c.customer_full_name,p.payment_method, p.payment_amount
from Payment p
join Booking b on p.booking_id = b.booking_id
join
Customer c on b.customer_id = c.customer_id
order by p.payment_amount DESC;

#9. 
select * 
from Customer
order by customer_full_name
limit 3 offset 1;

#10

select c.customer_id, c.customer_full_name, count(b.booking_id) as sl_phong
from Customer c
join Booking b on c.customer_id = b.customer_id
join Payment p on b.booking_id = p.booking_id
group by c.customer_id,  c.customer_full_name
having count(b.booking_id) >= 2 
and sum(p.payment_amount) > 1000;

#11
select r.room_id, r.room_type, r.room_price, sum(p.payment_amount)
as total
from Room r
join Booking b on r.room_id = b.room_id
join Payment p on b.booking_id = p.booking_id
group by r.room_id, r.room_type, r.room_price
having sum(p.payment_amount) < 1000
and count(distinct b.customer_id) >= 3;

#12
select c.customer_id, c.customer_full_name, b.room_id, sum(p.payment_amount) as total
from Customer c
join Booking b on c.customer_id = b.customer_id
join Payment p on b.booking_id = p.booking_id
group by c.customer_id, c.customer_full_name, b.room_id
having sum(p.payment_amount) >  1000;

#13
select customer_id, customer_full_name, customer_email,
customer_phone
from Customer
where Customer_full_name like '%Minh%' or customer_address like '%HaNoi%'
order by customer_full_name ASC;

#14
select room_id, room_type, room_price
from Room
order by room_price DESC
limit 5 offset 5;

#PHẦN 3: Tạo View
#15
create view view_booking_before0310 as
select r.room_id, r.room_type, c.customer_id, c.customer_full_name
from Booking b
join Room r on b.room_id = r.room_id
join Customer c on b.customer_id = c.customer_id
where b.check_in_date < '2025-03-10';

select * from view_booking_before0310;

#16
create view  view_16 as
select c.customer_id, c.customer_full_name, r.room_id, r.room_area
from Booking b
join Customer c on b.customer_id = c.customer_id
join Room r on b.room_id = r.room_id
where r.room_area > 30;

select * from view_16;

#PHẦN 4: Tạo Trigger
#17

DELIMITER //
create trigger check_insert_booking
before insert on Booking
for each row
begin
	if new.check_in_date > new.check_out_date then
		signal sqlstate '45000'
		set message_text = 'Ngày đặt phòng không thể sau ngày trả phòng được !';
    end if;
end //
DELIMITER ;

 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C010', 'R005', '2025-03-19', '2025-03-17', 800.0);
 
 #18
 
DELIMITER //
create trigger pdate_room_status_on_booking
after insert on Booking
for each row
begin
	update Room
    set room_status = 'Booked'
    where room_id = new.room_id;
end //
DELIMITER ;

select * from Room where room_id = 'R005';
 insert into Booking(customer_id,room_id,check_in_date,check_out_date,total_amount)
 value ('C010', 'R005', '2025-03-19', '2025-03-21', 480.0);
 select * from Room where room_id = 'R005';
 
 #PHẦN 5: Tạo Store Procedure
 #19
 DELIMITER //
 create procedure add_customer (
	in p_customer_id VARCHAR(5) ,
	in p_customer_full_name VARCHAR(100),
	in p_customer_email VARCHAR(100) ,
	in p_customer_phone VARCHAR(15) ,
	in p_customer_address VARCHAR(255)
 )
 begin 
 insert into Customer(customer_id, customer_full_name, customer_email, customer_phone, customer_address) 
value (p_customer_id,p_customer_full_name, p_customer_email, p_customer_phone, p_customer_address);
 end //
 
 DELIMITER ;
 
 #20
  DELIMITER //
 create procedure add_payment (
	in p_booking_id int ,
	in p_payment_method VARCHAR(50),
	in p_payment_date DATE,
	in p_payment_amount DECIMAL(10, 2)
 )
 begin 
 insert into Payment(booking_id,payment_method,payment_date,payment_amount)
 value (p_booking_id, p_payment_method, p_payment_date, p_payment_amount);
 end //
 
 DELIMITER ;

 
