package Ex3;

class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Email: " + email + ", Số điện thoại: " + phone;
    }
}