package Ex9;

import java.util.*;

class Contact {
    private static int nextId = 1;
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = nextId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }

    // Ghi đè equals và hashCode để Set kiểm tra trùng phoneNumber
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tên: " + name + " | SĐT: " + phoneNumber;
    }
}

