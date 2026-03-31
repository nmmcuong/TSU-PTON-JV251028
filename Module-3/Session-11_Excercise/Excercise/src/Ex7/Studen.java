package Ex7;

class Student {
    private String name;
    private String major;
    private double score;

    public Student(String name, String major, double score) {
        this.name = name;
        this.major = major;
        this.score = score;
    }

    public String getMajor() { return major; }
    public String getName() { return name; }
    public double getScore() { return score; }
}
