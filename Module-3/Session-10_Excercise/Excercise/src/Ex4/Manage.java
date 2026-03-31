package Ex4;

interface Manage<T> {
    void add(T item);
    void update(int id, T item);
    void delete(int id);
    void display();
}