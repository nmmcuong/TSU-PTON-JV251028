package Ex6;

interface Manage<T> {
    void add(T item);
    void update(String id, T item);
    void delete(String id);
    void display();
}