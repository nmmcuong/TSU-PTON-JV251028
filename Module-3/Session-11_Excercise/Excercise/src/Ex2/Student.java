package Ex2;

class Student {
    String name;
    int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("| name : %10s | age : %2d | grade : %f |", name, age, grade);
    }
}
