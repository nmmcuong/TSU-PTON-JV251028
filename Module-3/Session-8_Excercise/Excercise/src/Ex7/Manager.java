package Ex7;
//Lớp Manager kế thừa từ Employee
class Manager extends Employee {
 private double bonus;

 public Manager() {}

 public Manager(String name, String id, double salary, double bonus) {
     super(name, id, salary);
     this.bonus = bonus;
 }

 @Override
 public double getSalary() {
     // Lương quản lý = Lương cơ bản + Tiền thưởng
     return super.getSalary() + bonus;
 }

 @Override
 public String toString() {
     return super.toString() + " | Thưởng: " + bonus + " | Tổng thu nhập: " + getSalary();
 }
}

//Lớp Developer kế thừa từ Employee
class Developer extends Employee {
 private String programmingLanguage;

 public Developer() {}

 public Developer(String name, String id, double salary, String programmingLanguage) {
     super(name, id, salary);
     this.programmingLanguage = programmingLanguage;
 }

 @Override
 public double getSalary() {
     // Lương lập trình viên trả về lương cơ bản (theo mô tả đề bài)
     return super.getSalary();
 }

 @Override
 public String toString() {
     return super.toString() + " | Ngôn ngữ: " + programmingLanguage;
 }
}
